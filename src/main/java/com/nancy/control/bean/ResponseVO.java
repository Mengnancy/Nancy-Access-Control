package com.nancy.control.bean;

/**
 * @Author: Linglingxin
 * @Date: 2018/8/19 15:57
 */
public class ResponseVO {
    public int code;
    public Object data;

    public ResponseVO(Object data) {
        this.code = 1;
        this.data = data;
    }

    public ResponseVO(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
