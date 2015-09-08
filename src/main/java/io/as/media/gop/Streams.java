package io.as.media.gop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rasheed on on 2015-09-08.
 *
 * JSON to represent output of following command:
 * ffprobe -v quiet -print_format json -show_streams -select_streams v <media-file-name>
 *
 */
public class Streams {
    @JsonProperty("streams") private List<Stream> streams = new ArrayList<>();

    public Streams() {
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    public static Streams fromJSON(String json) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Streams.class);
    }
}