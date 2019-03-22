package com.liu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private Integer id;

    private String aTitle;

    private String aDec;

    private String aType;

    private String aCover;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date aDate;

    private Integer aViews;

    private String aContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaDec() {
        return aDec;
    }

    public void setaDec(String aDec) {
        this.aDec = aDec;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public String getaCover() {
        return aCover;
    }

    public void setaCover(String aCover) {
        this.aCover = aCover;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public Integer getaViews() {
        return aViews;
    }

    public void setaViews(Integer aViews) {
        this.aViews = aViews;
    }

    public String getaContent() {
        return aContent;
    }

    public void setaContent(String aContent) {
        this.aContent = aContent;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", aTitle='" + aTitle + '\'' +
                ", aDec='" + aDec + '\'' +
                ", aType='" + aType + '\'' +
                ", aCover='" + aCover + '\'' +
                ", aDate=" + aDate +
                ", aViews=" + aViews +
                ", aContent='" + aContent + '\'' +
                '}';
    }
}