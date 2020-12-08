package com.linfd.scri.disinfectrobot.entity;

public class BaseEntity {

    /**
     * errmsg : Start_OK
     * errno : 0
     * 测试一下
     */

    private String errmsg;
    private String errno;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }
}
