package com.xc.message.req;

/**
 * 图片消息
 * Created by Administrator on 2015/9/7.
 */
public class ImageMessage extends BaseMessage {

    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
