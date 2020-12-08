package com.linfd.scri.disinfectrobot.manager;

import com.linfd.scri.disinfectrobot.Contanst;
import com.whieenz.LogCook;

public class LogCookManager {

    public static void init(){
        String logPath = Contanst.CACHE_DIR+"/log";
        LogCook.getInstance() // 单例获取LogCook实例
                .setLogPath(logPath) //设置日志保存路径
                .setLogName("scri.log") //设置日志文件名
                .isOpen(true)  //是否开启输出日志
                .isSave(true)  //是否保存日志
                .initialize(); //完成初始化Crash监听
    }
}
