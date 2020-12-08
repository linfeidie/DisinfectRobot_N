package com.linfd.scri.disinfectrobot.manager;

import java.util.Random;
/*
* 获取随机数
* */
public class ObtainRandom {
    private static Random r = new Random(1);

    public static int get(){
        int ran1 = r.nextInt(100);
        return ran1;
    }
}
