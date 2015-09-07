package com.xc.message.resp;

import java.util.List;

/**
 * 响应消息之图文消息
 * Created by Administrator on 2015/9/7.
 */
public class NewsMessage extends BaseMessage {
    // 图文消息个数，限制为10条以内
    private int ArticleCount;

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    // 多条图文消息信息，默认第一个item为大图
    private List<Article> Articles;
}
