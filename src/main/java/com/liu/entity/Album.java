package com.liu.entity;

import java.util.Date;

public class Album {
    private Integer id;

    private String alDoc;

    private Date alDate;

    private String alImg;

    private String alPlace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlDoc() {
        return alDoc;
    }

    public void setAlDoc(String alDoc) {
        this.alDoc = alDoc;
    }

    public Date getAlDate() {
        return alDate;
    }

    public void setAlDate(Date alDate) {
        this.alDate = alDate;
    }

    public String getAlImg() {
        return alImg;
    }

    public void setAlImg(String alImg) {
        this.alImg = alImg;
    }

    public String getAlPlace() {
        return alPlace;
    }

    public void setAlPlace(String alPlace) {
        this.alPlace = alPlace;
    }
}