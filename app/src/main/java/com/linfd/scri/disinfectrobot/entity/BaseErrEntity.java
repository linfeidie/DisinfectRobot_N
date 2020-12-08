package com.linfd.scri.disinfectrobot.entity;

public class BaseErrEntity {
    public String errmsg;
    public String errno;
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

    @Override
    public String toString() {
        return "BaseErrEntity{" +
                "errmsg='" + errmsg + '\'' +
                ", errno='" + errno + '\'' +
                '}';
    }
}
