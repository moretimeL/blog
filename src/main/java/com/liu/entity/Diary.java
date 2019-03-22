package com.liu.entity;

import java.util.Date;

public class Diary {
    private Integer id;

    private String dContent;

    private String dUrl;

    private Integer dLikenum;

    private Date d_date;


    public Date getD_date() {
        return d_date;
    }

    public void setD_date(Date d_date) {
        this.d_date = d_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdContent() {
        return dContent;
    }

    public void setdContent(String dContent) {
        this.dContent = dContent;
    }

    public String getdUrl() {
        return dUrl;
    }

    public void setdUrl(String dUrl) {
        this.dUrl = dUrl;
    }

    public Integer getdLikenum() {
        return dLikenum;
    }

    public void setdLikenum(Integer dLikenum) {
        this.dLikenum = dLikenum;
    }
}