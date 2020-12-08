package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;

import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.tools.GsonUtil;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.entity.DataEntity;
import com.linfd.scri.disinfectrobot.entity.RobotStatusCallbackEntity;
import com.linfd.scri.disinfectrobot.observer.DataChanger;
import com.linfd.scri.disinfectrobot.observer.DataWatcher;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


/*
* 状态管理类  输入地图箭头bitmap
* */
public class UpdateStateControlManager {
    public static final String TAG = UpdateStateControlManager.class.getSimpleName();
    private static  UpdateStateControlManager ourInstance;

    private Rect rect = new Rect();//覆盖的位置  运行的位置
    private double map_update = -1;
    public boolean localization = true; //现在是什么模式  建图还是location
    private List<BitmapCallback> bitmapCallbackObservers = new ArrayList<>();//要被回调的观察者集合


    public static UpdateStateControlManager getInstance() {
        if (ourInstance == null){
            synchronized (UpdateStateControlManager.class){
                if (ourInstance == null){
                    ourInstance = new UpdateStateControlManager();
                }
            }
        }
        return ourInstance;
    }

    private UpdateStateControlManager() {
        DataChanger.getInstance().addObserver(watcher);
        //EventBus.getDefault().register(this);
    }

    public void setBitmapCallback(BitmapCallback bitmapCallback) {
        //this.bitmapCallback = bitmapCallback; 如果没有包含就加入
        if (!bitmapCallbackObservers.contains(bitmapCallback)){
            bitmapCallbackObservers.add(bitmapCallback);
        }

    }

    /*
    * 必须先初始化
    * */
    private void init(){
       // DataChanger.getInstance().addObserver(watcher);
    }
    private DataWatcher watcher = new DataWatcher() {

        @Override
        public void notifyUpdata(Object data) {
            if (data instanceof DataEntity) {
                DataEntity dataEntity = (DataEntity) data;
                if (dataEntity.getType().equalsIgnoreCase(Contanst.robot_status)) {

                    try {
                        Log.e("linfd", "机器人状态");
                        Log.e("linfd", dataEntity.getMessage());
                        final RobotStatusCallbackEntity satusEntity = GsonUtil.GsonToBean(dataEntity.getMessage(), RobotStatusCallbackEntity.class);
//
                        updateLocation(satusEntity);
                        localization = satusEntity.isLocalization();//赋值
                      //  updateActionState(satusEntity.getAction());
                        Log.e("linfd", Tools.getDateToString((long) satusEntity.get_hand_map_update()));
                        double map_update_now = satusEntity.get_hand_map_update();
                        //大于5分钟
                                if (map_update_now != map_update && (((System.currentTimeMillis()-map_update_now) > Contanst.GETMAPFREQUENCY) || (System.currentTimeMillis()-map_update_now)<0)){
                                    map_update = map_update_now;
                                    MapDataObtainManager.getInstance().start();
                                    Log.e(TAG,"重新获取地图");
                                }else if (map_update_now != map_update){//要删掉 测试
                                    double d= System.currentTimeMillis()- map_update_now;
                                    Log.e(TAG,"时间间隔是（测试）"+d);
                                }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("linfd", e.getMessage());
                    }
                }
            }
        }
    };
    /*
     * 运动的状态更新
     * */
    private void updateActionState(String action) {
        ActionState actionState = ActionState.valueOf(action);
        EventBus.getDefault().post(actionState);
    }


    public static enum ActionState{
         idle(0) ,   running(1) ,  pause(2) ,  finish(3) ,  stop(4);
        int value;
        ActionState(int state) {
            this.value = state;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    private void updateLocation(final RobotStatusCallbackEntity satusEntity) {
        if (satusEntity == null || Contanst.MAPPARAMENTITY == null) {
            return;
        }
        Tools.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (Contanst.MAPPARAMENTITY == null) {
                    return;
                }
/*
* 注意：satusEntity.getRobot_pose().get(0)，satusEntity.getRobot_pose().get(1)可能顺序有误
*
* */
                /*
                * 服务器定位变成可以画的rect
                * */
                rect = HandlePositionHelper.handle(satusEntity.getRobot_pose_real());

                //弧度转角度
                float angle = (float) (360 * satusEntity.getRobot_pose_real().get(2) / (2 * Math.PI));

                Log.e("linfd",rect.left+"=======left");
                Log.e("linfd",rect.top+"=======ltop");
                /*
                 * 解析出定位点位置和角度，画上去
                 * */
                ComBitmapManager.getInstance().startComposite(rect, angle, new ComBitmapManager.CompositeMapListener() {
                    @Override
                    public void compositeMapCallBack(Bitmap mapComposite) {
                        for (int i = 0; i < bitmapCallbackObservers.size(); i++) {
                            bitmapCallbackObservers.get(i).bitmapFinish(mapComposite);
                        }
//                        if (bitmapCallback != null) {
//                            bitmapCallback.bitmapFinish(mapComposite);
//                        }

                    }
                });
            }
        });
    }

    public interface  BitmapCallback {
       void  bitmapFinish(Bitmap bitmap);
    }
}
