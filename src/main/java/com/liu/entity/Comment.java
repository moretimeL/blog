package com.liu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment {
    private Integer id;
    private String cIp;
    private String cIcon;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", cIp='" + cIp + '\'' +
                ", cIcon='" + cIcon + '\'' +
                ", cDate=" + cDate +
                ", dId=" + dId +
                ", aId=" + aId +
                ", cType='" + cType + '\'' +
                ", cToid=" + cToid +
                ", cContent='" + cContent + '\'' +
                '}';
    }
}