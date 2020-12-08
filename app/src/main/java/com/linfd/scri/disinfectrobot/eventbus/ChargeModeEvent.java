package com.linfd.scri.disinfectrobot.eventbus;
/*
废弃
* 手动自动充电模式监听   充电模式  1:纯手动，2:半自动，3:纯自动，4:混动
* */
public class ChargeModeEvent {
    public int mode;

    public String getMode() {
        String des;
        if (mode == 1){
            des = "手动模式充电";
        }else if (mode == 2){
            des = "半自动模式充电";
        }else if (mode == 3){
            des = "自动模式充电";
        }else if (mode == 4){
            des = "混动充电";
        }else {
            des = "未知模式";
        }

        return des;
    }
}
