package com.linfd.scri.disinfectrobot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

//自启动博客
//https://blog.csdn.net/sinat_25112321/article/details/80104714?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4
public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {

        //屏幕唤醒
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        @SuppressLint("InvalidWakeLockTag") PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP
                | PowerManager.SCREEN_DIM_WAKE_LOCK, "BootBroadcastReceiver");
        wl.acquire();

        //屏幕解锁
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock kl = km.newKeyguardLock("BootBroadcastReceiver");
        kl.disableKeyguard();

        //启动APP
        if (intent.getAction().equals(ACTION)) {
            Intent intent2 = new Intent(context, BinTongActivity2.class);  // 要启动的Activity
            if (!(context instanceof Activity)) {
                //如果不是在Activity中显示Activity，必须要设置FLAG_ACTIVITY_NEW_TASK标志
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            context.startActivity(intent2);
        }
    }

}
