package com.linfd.scri.disinfectrobot.entity;
/*
* 修改密码返回
* */
public class ChangePwbEntity {

    /**
     * code : 200
     * message : Success
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
