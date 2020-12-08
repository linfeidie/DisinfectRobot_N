package com.linfd.scri.disinfectrobot.entity;

/*
* 另为一种形式基类
* */
public class BaseEntity2 {

    /**
     * code : 200
     * message : success
     */

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
