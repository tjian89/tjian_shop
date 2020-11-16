package com.tjian.common;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private int code;
    private String msg;
    private T result;

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static ResponseResult success(){
        return new ResponseResult(200, "t");
    }

    public static <T> ResponseResult successWithResult(T t){
        return new ResponseResult(200, "success", t);
    }

    public static ResponseResult failed(int code, String msg){
        return new ResponseResult(code, msg);
    }

    public static <T> ResponseResult failWithResult(int code, String msg, T t){
        return new ResponseResult(code, msg, t);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
