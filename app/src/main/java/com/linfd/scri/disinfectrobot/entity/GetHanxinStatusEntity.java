package com.linfd.scri.disinfectrobot.entity;
/*
* 获取韩信状态
* */
public class GetHanxinStatusEntity extends BaseEntity {

    /**
     * status : 韩信状态（1：已开启状态， 0：未开启状态）
     */

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
