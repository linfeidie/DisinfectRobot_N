package com.linfd.scri.disinfectrobot.manager;

import android.os.Handler;

import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;


/**
 * 文件描述：.
 * <p> 循环动作的类  结合LooerR使用
 * 作者：Created by 林飞堞 on 2019/9/24
 * <p>
 * 版本号：donghaoProect
 */
public class TimerManager3 {
    private static final TimerManager3 ourInstance = new TimerManager3();
    public  Handler mHandler = BaseApplication.getHandler();
    private Runnable r;
    public static TimerManager3 getInstance() {
        return ourInstance;
    }

    private TimerManager3() {
    }

    public void startLoop(){
        mHandler.postDelayed(r, Contanst.ORDER_INTERVAL);
    }
    public void start(Runnable r){
       this.start(r,Contanst.ORDER_INTERVAL);
    }

    public void start(Runnable r,int interval){
        this.r = r;
        this.removeRunnable(r);//先移除
        mHandler.postDelayed(r, interval);
    }

    /*
    * 优化，延迟取消  解决消息队列问题（不知道有没解决）
    *
    * */
    public void removeMessage(){

        mHandler.removeCallbacks(r);
        r = null;

    }

    public void removeRunnable(Runnable run){
        mHandler.removeCallbacks(run);
    }
}
