package com.linfd.scri.disinfectrobot.manager;

import java.util.HashMap;
import java.util.Map;
/*
* action 的枚举 正在的动作
* */
public class BitoActionManager {

    private static Map<Integer,String> actionMap = new HashMap<>();

    static {
        actionMap.put(0,"空白");
        actionMap.put(1,"向左旋转后举升");
        actionMap.put(2,"向左旋转后下放");
        actionMap.put(3,"向右旋转后举升");
        actionMap.put(4,"向右旋转后下放");
        actionMap.put(5,"前进举升");
        actionMap.put(6,"直下");
        actionMap.put(7,"原地举升");
        actionMap.put(8,"原地下降");
        actionMap.put(9,"工作举升");
        actionMap.put(10,"充电");
        actionMap.put(11,"向后退举升");
        actionMap.put(12,"向后退下降");
        actionMap.put(13,"向前充电");
        actionMap.put(14,"工作下降");
        actionMap.put(15,"回收货架");
        actionMap.put(16,"途经");
        actionMap.put(17,"结束充电");
        actionMap.put(18,"向左平移后举升");
        actionMap.put(19,"向右平移后下降");
        actionMap.put(20,"向右平移后举升");
        actionMap.put(21,"向右平移后下降");
    }
}
