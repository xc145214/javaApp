package com.xc.message.resp;

/**
 * 响应消息之文本消息
 * Created by Administrator on 2015/9/7.
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
