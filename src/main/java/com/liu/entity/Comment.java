package com.liu.entity;

import java.util.Date;

public class Comment {
    private Integer id;

    private String cIp;

    private String cIcon;

    private Date cDate;

    private Integer dId;

    private Integer aId;

    private String cType;

    private Integer cToid;

    private String cContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcIp() {
        return cIp;
    }

    public void setcIp(String cIp) {
        this.cIp = cIp;
    }

    public String getcIcon() {
        return cIcon;
    }

    public void setcIcon(String cIcon) {
        this.cIcon = cIcon;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Integer getcToid() {
        return cToid;
    }

    public void setcToid(Integer cToid) {
        this.cToid = cToid;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }
}