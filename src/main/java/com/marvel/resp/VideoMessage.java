package com.marvel.resp;

/**
 * 视频消息
 * 
 * @author Marvel Cheng
 */
public class VideoMessage extends BaseMessage {
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
