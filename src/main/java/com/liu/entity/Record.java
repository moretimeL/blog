package com.liu.entity;

import java.util.Date;

public class Record {
    private Integer id;

    private String rIp;

    private Date rDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrIp() {
        return rIp;
    }

    public void setrIp(String rIp) {
        this.rIp = rIp;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }
}