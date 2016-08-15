package com.marvel.resp;

/**
 * 图片消息
 * 
 * @author Marvel Cheng
 */
public class ImageMessage extends BaseMessage {
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
