package com.linfd.scri.disinfectrobot.entity;
/*\
*
* */
public class BaseEntity {

    /**
     * code : 200
     * message : success
     */

    private int code;
    private String message;
    private String msg;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
