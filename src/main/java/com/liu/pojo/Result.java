package com.liu.pojo;

import java.util.List;

public class Result {
    private String state;
    private Integer code;
    private String msg;
    private Object data;
    private List<Object> datas;

    public Result(String state, String msg, Object data, List<Object> datas,Integer code) {
        this.state = state;
        this.msg = msg;
        this.data = data;
        this.datas = datas;
        this.code = code;
    }

    public Result() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Result{" +
                "state='" + state + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", datas=" + datas +
                '}';
    }
}
