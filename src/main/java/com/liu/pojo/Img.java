package com.liu.pojo;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-02-22 17:22
 **/

public class Img {
    private String title;
    private String src;


    public Img(){}
    public Img(String title, String src) {
        this.title = title;
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
