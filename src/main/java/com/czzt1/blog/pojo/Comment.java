package com.czzt1.blog.pojo;

import java.util.Date;

public class Comment {
    private int article_id;
    private String author_area;
    private String author_name;
    private String content;

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "article_id=" + article_id +
                ", author_area='" + author_area + '\'' +
                ", author_name='" + author_name + '\'' +
                ", content='" + content + '\'' +
                ", comment_time=" + comment_time +
                '}';
    }

    public String getAuthor_area() {
        return author_area;
    }

    public void setAuthor_area(String author_area) {
        this.author_area = author_area;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    private String comment_time;
}
