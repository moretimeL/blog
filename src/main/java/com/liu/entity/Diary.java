package com.liu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Diary {
    private Integer id;
    private String dContent;
    private String dUrl;
    private Integer dLikenum;
    @JsonFormat(pattern = "HH:mm:ss yyyy/MM/dd",timezone = "GMT+8")
    private Date d_date;
    private Integer comNum;

    public Integer getComNum() {
        return comNum;
    }

    public void setComNum(Integer comNum) {
        this.comNum = comNum;
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

    public Date getD_date() {
        return d_date;
    }

    public void setD_date(Date d_date) {
        this.d_date = d_date;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", dContent='" + dContent + '\'' +
                ", dUrl='" + dUrl + '\'' +
                ", dLikenum=" + dLikenum +
                ", d_date=" + d_date +
                ", comNum=" + comNum +
                '}';
    }
}