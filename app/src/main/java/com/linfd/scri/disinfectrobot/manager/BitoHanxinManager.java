package com.linfd.scri.disinfectrobot.manager;

import java.util.HashMap;
import java.util.Map;

/*
* 韩信状态
* */
public class BitoHanxinManager {
    private static Map<Integer,String> stateMap = new HashMap<>();
    static {
        stateMap.put(0,"未开启");
        stateMap.put(1,"开启");
    }

    public static String obtainState(int state){
        return stateMap.get(state);
    }
}
