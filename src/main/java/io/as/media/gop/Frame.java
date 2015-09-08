package io.as.media.gop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.annotation.Generated;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
public class Frame {
	@JsonProperty("pkt_dts") private Integer pkt_dts;
	@JsonProperty("pkt_pts_time") private Float pkt_pts_time;
	@JsonProperty("pix_fmt") private String pix_fmt;
	@JsonProperty("pkt_duration") private Integer pkt_duration;
	@JsonProperty("pkt_size") private Integer pkt_size;
	@JsonProperty("display_picture_number") private Integer display_picture_number;
	@JsonProperty("top_field_first") private Integer top_field_first;
	@JsonProperty("pkt_pos") private Integer pkt_pos;
	@JsonProperty("sample_aspect_ratio") private String sample_aspect_ratio;
	@JsonProperty("coded_picture_number") private Integer coded_picture_number;
	@JsonProperty("media_type") private String media_type;
	@JsonProperty("pkt_pts") private Integer pkt_pts;
	@JsonProperty("pkt_duration_time") private Float pkt_duration_time;
	@JsonProperty("pict_type") private String pict_type;
	@JsonProperty("width") private Integer width;
	@JsonProperty("repeat_pict") private Integer repeat_pict;
	@JsonProperty("interlaced_frame") private Integer interlaced_frame;
	@JsonProperty("pkt_dts_time") private Float pkt_dts_time;
	@JsonProperty("best_effort_timestamp") private Integer best_effort_timestamp;
	@JsonProperty("best_effort_timestamp_time") private Float best_effort_timestamp_time;
	@JsonProperty("key_frame") private Integer key_frame;
	@JsonProperty("height") private Integer height;

    // specifically in audio only files
    @JsonProperty("sample_fmt") private String sample_fmt;
    @JsonProperty("nb_samples") private Integer nb_samples;
    @JsonProperty("channels") private Integer channels;
    @JsonProperty("channel_layout") private String channel_layout;

    /**
     * default constructor!
     */
    public Frame() {
    }

    public Integer getChannels() {
        return channels;
    }

    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    public String getChannel_layout() {
        return channel_layout;
    }

    public void setChannel_layout(String channel_layout) {
        this.channel_layout = channel_layout;
    }

    public Integer getNb_samples() {
        return nb_samples;
    }

    public void setNb_samples(Integer nb_samples) {
        this.nb_samples = nb_samples;
    }

    public String getSample_fmt() {
        return sample_fmt;
    }

    public void setSample_fmt(String sample_fmt) {
        this.sample_fmt = sample_fmt;
    }

    public Integer getPkt_dts() {
        return pkt_dts;
    }

    public void setPkt_dts(Integer pkt_dts) {
        this.pkt_dts = pkt_dts;
    }

    public Float getPkt_pts_time() {
        return pkt_pts_time;
    }

    public void setPkt_pts_time(Float pkt_pts_time) {
        this.pkt_pts_time = pkt_pts_time;
    }

    public String getPix_fmt() {
        return pix_fmt;
    }

    public void setPix_fmt(String pix_fmt) {
        this.pix_fmt = pix_fmt;
    }

    public Integer getPkt_duration() {
        return pkt_duration;
    }

    public void setPkt_duration(Integer pkt_duration) {
        this.pkt_duration = pkt_duration;
    }

    public Integer getPkt_size() {
        return pkt_size;
    }

    public void setPkt_size(Integer pkt_size) {
        this.pkt_size = pkt_size;
    }

    public Integer getDisplay_picture_number() {
        return display_picture_number;
    }

    public void setDisplay_picture_number(Integer display_picture_number) {
        this.display_picture_number = display_picture_number;
    }

    public Integer getTop_field_first() {
        return top_field_first;
    }

    public void setTop_field_first(Integer top_field_first) {
        this.top_field_first = top_field_first;
    }

    public Integer getPkt_pos() {
        return pkt_pos;
    }

    public void setPkt_pos(Integer pkt_pos) {
        this.pkt_pos = pkt_pos;
    }

    public String getSample_aspect_ratio() {
        return sample_aspect_ratio;
    }

    public void setSample_aspect_ratio(String sample_aspect_ratio) {
        this.sample_aspect_ratio = sample_aspect_ratio;
    }

    public Integer getCoded_picture_number() {
        return coded_picture_number;
    }

    public void setCoded_picture_number(Integer coded_picture_number) {
        this.coded_picture_number = coded_picture_number;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public Integer getPkt_pts() {
        return pkt_pts;
    }

    public void setPkt_pts(Integer pkt_pts) {
        this.pkt_pts = pkt_pts;
    }

    public Float getPkt_duration_time() {
        return pkt_duration_time;
    }

    public void setPkt_duration_time(Float pkt_duration_time) {
        this.pkt_duration_time = pkt_duration_time;
    }

    public String getPict_type() {
        return pict_type;
    }

    public void setPict_type(String pict_type) {
        this.pict_type = pict_type;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getRepeat_pict() {
        return repeat_pict;
    }

    public void setRepeat_pict(Integer repeat_pict) {
        this.repeat_pict = repeat_pict;
    }

    public Integer getInterlaced_frame() {
        return interlaced_frame;
    }

    public void setInterlaced_frame(Integer interlaced_frame) {
        this.interlaced_frame = interlaced_frame;
    }

    public Float getPkt_dts_time() {
        return pkt_dts_time;
    }

    public void setPkt_dts_time(Float pkt_dts_time) {
        this.pkt_dts_time = pkt_dts_time;
    }

    public Integer getBest_effort_timestamp() {
        return best_effort_timestamp;
    }

    public void setBest_effort_timestamp(Integer best_effort_timestamp) {
        this.best_effort_timestamp = best_effort_timestamp;
    }

    public Float getBest_effort_timestamp_time() {
        return best_effort_timestamp_time;
    }

    public void setBest_effort_timestamp_time(Float best_effort_timestamp_time) {
        this.best_effort_timestamp_time = best_effort_timestamp_time;
    }

    public Integer getKey_frame() {
        return key_frame;
    }

    public void setKey_frame(Integer key_frame) {
        this.key_frame = key_frame;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
