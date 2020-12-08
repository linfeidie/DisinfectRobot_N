package com.linfd.scri.disinfectrobot.manager;

import java.util.HashMap;
import java.util.Map;
/*
* 宾通的任务状态
* */
public class BitoActionStateManager {
    private static Map<Integer,String> stateMap = new HashMap<>();
    static {
        //搞错了
        stateMap.put(0,"待处理");//已创建
        stateMap.put(1,"待执行");//已预定
        stateMap.put(2,"执行中");
        stateMap.put(3,"任务完成");
        stateMap.put(4,"任务失败中断");//已中止
        stateMap.put(5,"任务取消");//已取消
        stateMap.put(6,"移动到运输起始点");
        stateMap.put(7,"进行运输起始点动作");
        stateMap.put(8,"移动到运输终止点");
        stateMap.put(9,"进行运输终止点动作");//执行结束操作
    }

    public static String obtainState(int state){
        return stateMap.get(state);
    }
}
