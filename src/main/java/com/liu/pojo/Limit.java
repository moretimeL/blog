package com.liu.pojo;

/**
 * @program: blog
 * @author: smile liu
 * @description: 用来存放主页的分页数据和分类
 * @create: 2018-12-24 16:48
 **/

public class Limit {
    private Integer limit;
    private Integer curr;
    private String type;
    public Limit(){

    }

    public Limit(Integer limit, Integer curr, String type) {
        this.limit = limit;
        this.curr = curr;
        this.type = type;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getCurr() {
        return curr;
    }

    public void setCurr(Integer curr) {
        this.curr = curr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Limit{" +
                "limit=" + limit +
                ", curr=" + curr +
                ", type='" + type + '\'' +
                '}';
    }
}
