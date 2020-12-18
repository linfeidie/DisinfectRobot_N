package com.linfd.scri.disinfectrobot.tools;

import com.linfd.scri.disinfectrobot.entity.RobotRegisterEntity;
/*
* 注册失败的土司
* */
public class RobotRegisterTost {

    public static void show(RobotRegisterEntity entity){
        if (entity.getCode() == 100920){
            Tools.showToast("连接失败，请推到节点位置再连接");
        }
    }
}
