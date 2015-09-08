package io.as.media.gop;

import org.apache.commons.io.Charsets;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rasheed on 2015-09-07.
 */
public class GopValidator
{

    public static void main(String[] args) throws Exception
    {
        File root = new File("/tmp/roku");
        List<File> mp4Only = new ArrayList<File>();
        searchForMp4Files(root, mp4Only);
        Map<String, Frames> framesPerBitrate = new HashMap<>();

        for (File file: mp4Only)
        {
            String absolutePath = file.getAbsolutePath();
            String filePath = absolutePath.
                    substring(0, absolutePath.lastIndexOf(File.separator));
            String bitrate = filePath.substring(filePath.lastIndexOf(File.separator)+1, filePath.length());
            String cmd = "ffprobe -show_frames -print_format json -select_streams 0:v -i " + absolutePath;
            framesPerBitrate.put(bitrate, runFfprobeCommand(cmd));

            System.out.println("processed bitrate - " + bitrate);
        }
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

    private static Frames runFfprobeCommand(String command) throws Exception
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
                //System.out.println(line);
                json.append(line+"\n");
            }
            process.waitFor();
            if (process.exitValue() != 0)
            {
                throw new Exception("ffprobe command execution failed!");
            }
        }
        catch(Exception e)
        {
            throw e;
        }
        finally
        {
            brIn.close();
        }
        return Frames.fromJSON(json.toString());
    }

    private static BufferedReader runCommand(List<String> args) throws Exception
    {
        ProcessBuilder builder = new ProcessBuilder(args);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        return new BufferedReader( new InputStreamReader(p.getInputStream(), Charsets.UTF_8) );
    }

    private static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
