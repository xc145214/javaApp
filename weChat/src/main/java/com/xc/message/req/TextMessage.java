package com.xc.message.req;

/**
 * 文本消息
 * Created by Administrator on 2015/9/6.
 */
public class TextMessage extends BaseMessage {

    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
