package com.linfd.scri.disinfectrobot.entity;
/*
* 查询⾃动充电开关状态
* */
public class GetChargingStatusEntity extends BaseEntity {

    /**
     * status : 1
     */

    private int status;

    public String getStatus() {
        String des;
        if (status == 1){
            des = "手动充电";
        }else if (status == 2){
            des = "半自动充电";
        }else if (status == 3){
            des = "纯自动充电";
        }else if (status == 4){
            des = "混动充电";
        }else {
            des = "未知模式";
        }

        return des;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
