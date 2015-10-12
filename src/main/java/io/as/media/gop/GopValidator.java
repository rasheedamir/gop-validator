package io.as.media.gop;

import org.apache.commons.io.Charsets;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Rasheed on 2015-09-07.
 */
public class GopValidator
{
    public static void main(String[] args) throws Exception
    {
        File root = new File("/tmp/roku");
        List<File> mp4Only = new ArrayList<>();

        searchForMp4Files(root, mp4Only);

        List<File> mp4VideoOnly = filterMp4VideoFiles(mp4Only);

        Map<String, Frames> framesPerBitrate = new HashMap<>();

        // find frames
        for (File file: mp4VideoOnly)
        {
            String absolutePath = file.getAbsolutePath();
            String filePath = absolutePath.
                    substring(0, absolutePath.lastIndexOf(File.separator));
            String bitrate = filePath.substring(filePath.lastIndexOf(File.separator)+1, filePath.length());
            String cmd = "ffprobe -show_frames -print_format json -select_streams 0:v -i " + absolutePath;
            framesPerBitrate.put(bitrate, findFrames(cmd));

            System.out.println("processed bitrate - " + bitrate);

            //break;
        }

        Map<String, Collection<Integer>> bitratesIFramesLocations = new HashMap<>();
        Map<String, Collection<Double>> bitratesIFramesTimings = new HashMap<>();

        // print index's of I frames
        for (Map.Entry<String, Frames> entry: framesPerBitrate.entrySet())
        {
            int index = 1;
            //System.out.println("STARTING SHOWING IFRAMES OF BITRATE" + entry.getKey());
            Collection<Integer> iframeLocations = new ArrayList<>();
            Collection<Double> iframeTimes = new ArrayList<>();
            for (Frame frame: entry.getValue().getFrames())
            {
                if(frame.isIframe())
                {
                    //System.out.println(index + " - " + frame.getPkt_pts_time());
                    iframeTimes.add(frame.getPkt_pts_time());
                    iframeLocations.add(index);
                }
                index++;
            }
            //System.out.println("DONE SHOWING IFRAMES OF BITRATE" + entry.getKey());
            //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
            bitratesIFramesLocations.put(entry.getKey(), iframeLocations);
            bitratesIFramesTimings.put(entry.getKey(), iframeTimes);
        }

        // pick up item zero
        Map.Entry<String, Collection<Integer>> firstEntry = bitratesIFramesLocations.entrySet().iterator().next();

        for(Map.Entry<String, Collection<Integer>>  entry: bitratesIFramesLocations.entrySet())
        {
            Collection<Integer> copyFirstLocationsEntry = new ArrayList<>(firstEntry.getValue());
            Collection<Integer> nextBitrateIframeLocations = entry.getValue();

            copyFirstLocationsEntry.removeAll(nextBitrateIframeLocations);
            if(copyFirstLocationsEntry.size() > 0)
            {
                System.out.println(String.format("comparing index of %s with %s", firstEntry.getKey(), entry.getKey()));
                System.out.println("GOP SIZE MISMATCH!");
            }
        }

        // pick up item zero
        Map.Entry<String, Collection<Double>> firstTimingsEntry = bitratesIFramesTimings.entrySet().iterator().next();

        for(Map.Entry<String, Collection<Double>>  entry: bitratesIFramesTimings.entrySet())
        {
            Collection<Double> copyFirstTimingsEntry = new ArrayList<>(firstTimingsEntry.getValue());
            Collection<Double> nextBitrateIframeTimings = entry.getValue();

            copyFirstTimingsEntry.removeAll(nextBitrateIframeTimings);
            if(copyFirstTimingsEntry.size() > 0)
            {
                System.out.println(String.format("comparing timings of %s with %s", firstEntry.getKey(), entry.getKey()));
                System.out.println("OUCH .... GOP TIMINGS SIZE MISMATCH!");
            }
        }
    }

    public static List<File> filterMp4VideoFiles(List<File> mp4Only) throws Exception
    {
        List<File> videoOnly = new ArrayList<>();

        for(File file: mp4Only)
        {
            if(hasVideo(file.getAbsolutePath()))
            {
                videoOnly.add(file);
            }
        }

        return videoOnly;
    }

    // search mp4 files
    public static void searchForMp4Files(File root, List<File> mp4Only)
    {
        if(root == null || mp4Only == null) return; //just for safety

        if(root.isDirectory())
        {
            for(File file : root.listFiles())
            {
                searchForMp4Files(file, mp4Only);
            }
        }
        else if(root.isFile() && root.getName().endsWith(".mp4"))
        {
            mp4Only.add(root);
        }
    }

    private static Frames findFrames(String command) throws Exception
    {
        System.out.println("running command " + command);
        StringBuilder json = new StringBuilder();
        BufferedReader brIn = null;
        try
        {
            Process process = Runtime.getRuntime().exec(command);
            brIn = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while (( line = brIn.readLine()) != null)
            {
                json.append(line).append("\n");
            }
            process.waitFor();
            if (process.exitValue() != 0)
            {
                throw new Exception("ffprobe command execution failed!");
            }
        }
        finally
        {
            if (brIn == null) throw new AssertionError();
            brIn.close();
        }
        return Frames.fromJSON(json.toString());
    }

    private static boolean hasVideo(final String mediaFilePathAndName) throws Exception
    {
        final List<String> params = new ArrayList<>();
        params.add("ffprobe");

        params.add("-v");
        params.add("quiet");

        params.add("-print_format");
        params.add("json");

        params.add("-show_streams");

        params.add("-select_streams");
        params.add("v");

        params.add("-i");
        params.add(mediaFilePathAndName);

        ProcessBuilder builder = new ProcessBuilder(params);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedReader brIn = new BufferedReader(new InputStreamReader(process.getInputStream(), Charsets.UTF_8));

        String line;
        StringBuilder streamsListAsString = new StringBuilder();
        while((line = brIn.readLine())!=null)
        {
            streamsListAsString.append(line);
        }

        process.waitFor();
        if (process.exitValue() != 0)
        {
            throw new Exception("ffprobe command execution failed!");
        }

        return Streams.fromJSON(streamsListAsString.toString()).getStreams().size() > 0;
    }
}
