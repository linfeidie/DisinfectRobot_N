package com.linfd.scri.disinfectrobot.eventbus;

/*
* 机器是否注册监听
* */
public class RobotRegisterEvent {
    public int status ;//0 注册成功  ，1 注册失败 ,2 注销成功 ，3注销失败\

    public String getStatus() {
        String des = "";
        if (status == 0){
            des = "已注册";//注册成功
        }else if(status == 1){
            des = "未注册";//注册失败
        }else if(status == 2){
            des = "未注册";//注销成功
        }else if(status == 3){
            des = "注销失败";
        }else {
            des = "未知";
        }
        return des;
    }
}
