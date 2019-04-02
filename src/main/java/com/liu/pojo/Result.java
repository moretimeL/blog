package com.liu.pojo;

import java.util.List;

public class Result {
    private String state;
    private Integer code;
    private String msg;
    private Object data;
    private List<?> datas;

    @Override
    public String toString() {
        return "Result{" +
                "state='" + state + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", datas=" + datas +
                '}';
    }

    public Result() {
    }

    public Result(String state, Integer code, String msg, Object data, List<?> datas) {
        this.state = state;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.datas = datas;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public List<?> getDatas() {
        return datas;
    }

    public void setDatas(List<?> datas) {
        this.datas = datas;
    }
}
