package com.linfd.scri.disinfectrobot;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.linfd.scri.disinfectrobot.listener.SimpleUdpListener;
import com.linfd.scri.disinfectrobot.manager.AckListenerService;
import com.linfd.scri.disinfectrobot.manager.CompareEntityManager;
import com.linfd.scri.disinfectrobot.manager.GetFromServerData;
import com.linfd.scri.disinfectrobot.manager.HeartbeatManager3;
import com.linfd.scri.disinfectrobot.manager.HttpRequestManager;
import com.linfd.scri.disinfectrobot.manager.LogCookManager;
import com.linfd.scri.disinfectrobot.manager.LooperDisinStatusService;
import com.linfd.scri.disinfectrobot.manager.LooperStatusService;
import com.linfd.scri.disinfectrobot.manager.ObtainStatusStamp;
import com.linfd.scri.disinfectrobot.manager.ServerListeners;
import com.linfd.scri.disinfectrobot.manager.TimerManager;
import com.linfd.scri.disinfectrobot.manager.UdpControlSendManager;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.whieenz.LogCook;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class BaseApplication extends Application {
  private static BaseApplication application;
  private static int mainTid;
  private static Handler handler;
  public static Rect chargerect;//充电桩位置
  public static boolean isdrawPaht = true;//当前地图是否绘制行走路径
  public static boolean isFistBoot = true; //是否是开机第一次启动


  @Override
  public void onCreate() {
    super.onCreate();
    application=this;
    mainTid = android.os.Process.myTid();
    handler=new Handler();
   // CrashHandler.getInstance().initCrashHandler(this);
    ObtainStatusStamp.init();
    AckListenerService.init();
    GetFromServerData.listener();

    //LooperDisinStatusService.obtainStatus();
   //开机就获取机器人状态和消毒状态
    LooperStatusService.obtainStatus();
    ServerListeners.register();
    //开机要启动这个 否则无地图数据返回  好像又说不用自己启动了  留给用户自己去启动
    //UdpControlSendManager.getInstance().set_navi_mode_build(Contanst.id,Contanst.to_id);

   // LogCookManager.init();
    CompareEntityManager.getInstance().start();

    HttpRequestManager.getInstance().init();


  }


  public static Context getApplication() {
    return application;
  }
  public static int getMainTid() {
    return mainTid;
  }
  public static Handler getHandler() {
    return handler;
  }
}
