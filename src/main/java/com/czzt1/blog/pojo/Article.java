package com.czzt1.blog.pojo;

import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * @Author czzt1
 * @Date 2019-06-19- 17:54
 */
public class Article {
    private int id;
    private String title;
    private String crt_date;
    private String source_url;
    private String source_name;
    private int comment_count;
    private List<Label> labelList;

    public List<Label> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
    }

    private int view_count;
    private String body;
    private String cover_img;
    private String short_text;


    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", crt_date='" + crt_date + '\'' +
                ", source_url='" + source_url + '\'' +
                ", source_name='" + source_name + '\'' +
                ", view_count=" + view_count +
                ", body='" + body + '\'' +
                ", cover_img='" + cover_img + '\'' +
                ", short_text='" + short_text + '\'' +
                ", labelList=" + labelList +
                '}';
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }


    public String getShort_text() {
        return short_text;
    }

    public void setShort_text(String short_text) {
        this.short_text = short_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCrt_date() {
        return crt_date;
    }

    public void setCrt_date(String crt_date) {
        this.crt_date = crt_date;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }
}
