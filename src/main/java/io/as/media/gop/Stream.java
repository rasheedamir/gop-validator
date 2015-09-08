package io.as.media.gop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.annotation.Generated;
import java.util.Map;

/**
 * Created by Rasheed on 2015-09-08.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
public class Stream {
    @JsonProperty("pix_fmt") private String pix_fmt;
    @JsonProperty("r_frame_rate") private String r_frame_rate;
    @JsonProperty("start_pts") private Integer start_pts;
    @JsonProperty("duration_ts") private Integer duration_ts;
    @JsonProperty("duration") private Float duration;
    @JsonProperty("bit_rate") private Integer bit_rate;
    @JsonProperty("sample_aspect_ratio") private String sample_aspect_ratio;
    @JsonProperty("is_avc") private Integer is_avc;
    @JsonProperty("codec_tag_string") private String codec_tag_string;
    @JsonProperty("avg_frame_rate") private String avg_frame_rate;
    @JsonProperty("nb_frames") private Integer nb_frames;
    @JsonProperty("codec_long_name") private String codec_long_name;
    @JsonProperty("height") private Integer height;
    @JsonProperty("nal_length_size") private Integer nal_length_size;
    @JsonProperty("chroma_location") private String chroma_location;
    @JsonProperty("time_base") private String time_base;
    @JsonProperty("level") private Integer level;
    @JsonProperty("profile") private String profile;
    @JsonProperty("bits_per_raw_sample") private Integer bits_per_raw_sample;
    @JsonProperty("index") private Integer index;
    @JsonProperty("codec_name") private String codec_name;
    @JsonProperty("tags") private Map<String, String> tags;
    @JsonProperty("start_time") private Float start_time;
    @JsonProperty("disposition") private Map<String, Integer> disposition;
    @JsonProperty("codec_tag") private String codec_tag;
    @JsonProperty("has_b_frames") private Integer has_b_frames;
    @JsonProperty("refs") private Integer refs;
    @JsonProperty("codec_time_base") private String codec_time_base;
    @JsonProperty("width") private Integer width;
    @JsonProperty("display_aspect_ratio") private String display_aspect_ratio;
    @JsonProperty("codec_type") private String codec_type;

    // default constructor
    public Stream() {

    }

    public String getPix_fmt() {
        return pix_fmt;
    }

    public void setPix_fmt(String pix_fmt) {
        this.pix_fmt = pix_fmt;
    }

    public String getR_frame_rate() {
        return r_frame_rate;
    }

    public void setR_frame_rate(String r_frame_rate) {
        this.r_frame_rate = r_frame_rate;
    }

    public Integer getStart_pts() {
        return start_pts;
    }

    public void setStart_pts(Integer start_pts) {
        this.start_pts = start_pts;
    }

    public Integer getDuration_ts() {
        return duration_ts;
    }

    public void setDuration_ts(Integer duration_ts) {
        this.duration_ts = duration_ts;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Integer getBit_rate() {
        return bit_rate;
    }

    public void setBit_rate(Integer bit_rate) {
        this.bit_rate = bit_rate;
    }

    public String getSample_aspect_ratio() {
        return sample_aspect_ratio;
    }

    public void setSample_aspect_ratio(String sample_aspect_ratio) {
        this.sample_aspect_ratio = sample_aspect_ratio;
    }

    public Integer getIs_avc() {
        return is_avc;
    }

    public void setIs_avc(Integer is_avc) {
        this.is_avc = is_avc;
    }

    public String getCodec_tag_string() {
        return codec_tag_string;
    }

    public void setCodec_tag_string(String codec_tag_string) {
        this.codec_tag_string = codec_tag_string;
    }

    public String getAvg_frame_rate() {
        return avg_frame_rate;
    }

    public void setAvg_frame_rate(String avg_frame_rate) {
        this.avg_frame_rate = avg_frame_rate;
    }

    public Integer getNb_frames() {
        return nb_frames;
    }

    public void setNb_frames(Integer nb_frames) {
        this.nb_frames = nb_frames;
    }

    public String getCodec_long_name() {
        return codec_long_name;
    }

    public void setCodec_long_name(String codec_long_name) {
        this.codec_long_name = codec_long_name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getNal_length_size() {
        return nal_length_size;
    }

    public void setNal_length_size(Integer nal_length_size) {
        this.nal_length_size = nal_length_size;
    }

    public String getChroma_location() {
        return chroma_location;
    }

    public void setChroma_location(String chroma_location) {
        this.chroma_location = chroma_location;
    }

    public String getTime_base() {
        return time_base;
    }

    public void setTime_base(String time_base) {
        this.time_base = time_base;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getBits_per_raw_sample() {
        return bits_per_raw_sample;
    }

    public void setBits_per_raw_sample(Integer bits_per_raw_sample) {
        this.bits_per_raw_sample = bits_per_raw_sample;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getCodec_name() {
        return codec_name;
    }

    public void setCodec_name(String codec_name) {
        this.codec_name = codec_name;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    public Float getStart_time() {
        return start_time;
    }

    public void setStart_time(Float start_time) {
        this.start_time = start_time;
    }

    public Map<String, Integer> getDisposition() {
        return disposition;
    }

    public void setDisposition(Map<String, Integer> disposition) {
        this.disposition = disposition;
    }

    public String getCodec_tag() {
        return codec_tag;
    }

    public void setCodec_tag(String codec_tag) {
        this.codec_tag = codec_tag;
    }

    public Integer getHas_b_frames() {
        return has_b_frames;
    }

    public void setHas_b_frames(Integer has_b_frames) {
        this.has_b_frames = has_b_frames;
    }

    public Integer getRefs() {
        return refs;
    }

    public void setRefs(Integer refs) {
        this.refs = refs;
    }

    public String getCodec_time_base() {
        return codec_time_base;
    }

    public void setCodec_time_base(String codec_time_base) {
        this.codec_time_base = codec_time_base;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getDisplay_aspect_ratio() {
        return display_aspect_ratio;
    }

    public void setDisplay_aspect_ratio(String display_aspect_ratio) {
        this.display_aspect_ratio = display_aspect_ratio;
    }

    public String getCodec_type() {
        return codec_type;
    }

    public void setCodec_type(String codec_type) {
        this.codec_type = codec_type;
    }
}
