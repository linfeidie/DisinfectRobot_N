package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Bitmap;
import android.util.Log;


import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.entity.GetMapCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.GetMapParamCallbackEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
* 组合成非解压数据
* */
public class HandleSubpackageManager {

    public static final String TAG = HandleSubpackageManager.class.getSimpleName();
    private static HandleSubpackageManager instance;
    private int countIndex = 0;
    private GetMapParamCallbackEntity getMapParamCallbackEntity;//地图参数

    private List<GetMapCallbackEntity> getMapCallbackEntities;
    private List<GetMapCallbackEntity> tempEntitys;//缓存
    private GetMapCallbackEntity supperMapData;//完整一个数据包，是非解压的数据（注意：没有解压的）
    private ObtainMapManager.MapListenter mapListenter;//回调给上层
    private Executor executor;

    private List<GetMapCallbackEntity> getGetMapCallbackEntities() {
        return getMapCallbackEntities;
    }

    private List<GetMapCallbackEntity> getTempEntitys() {
        return tempEntitys;
    }

    public static HandleSubpackageManager getInstance() {

        if (instance == null) {
            synchronized (HandleSubpackageManager.class) {
                if (instance == null) {
                    instance = new HandleSubpackageManager();
                }
            }
        }
        return instance;
    }


    /*
     * 构造函数
     * */
    private HandleSubpackageManager() {
        getMapCallbackEntities = new ArrayList<>();
        tempEntitys = new ArrayList<>();
        executor= Executors.newSingleThreadExecutor();
    }
    public void setMapParam(GetMapParamCallbackEntity getMapParamCallbackEntity){
        this.getMapParamCallbackEntity = getMapParamCallbackEntity;
    }
    //主要方法
    public void handerMap(GetMapCallbackEntity getMapCallbackEntity, HandlePackageListener listener) {

        if (getMapParamCallbackEntity == null){
            mapListenter.error("没有地图参数");
            throw new RuntimeException("没调用setMapParam方法");
        }

        tempEntitys.add(getMapCallbackEntity);

        // 表示接收完了
        if (tempEntitys.size() + getGetMapCallbackEntities().size() == getMapParamCallbackEntity.getPack_num()) {
            getMapCallbackEntities.addAll(tempEntitys);
            receiveMapFinish();
            cleanData();
            //Tools.showToast("传完了");
            Log.e(TAG, "传完了");
        }
        /*
         * 10个包
         * */
        if (tempEntitys.size() == Contanst.REQUEST_MAPPACK_COUNT) {
            getMapCallbackEntities.addAll(tempEntitys);
            tempEntitys.clear();
            countIndex += Contanst.REQUEST_MAPPACK_COUNT;
            listener.nextPackage(countIndex);
        }

    }
/*
* 实现它可以得到地图
* */
    public void setMapListenter(ObtainMapManager.MapListenter mapListenter){
        this.mapListenter = mapListenter;
    }

    /*
     * 地图数据接收完就会触发这个方法，整合数据
     * */
    private void receiveMapFinish() {
        /*
        * 注意 以后要找出问题
        * */
        try {
            for (int i = 0; i < getMapParamCallbackEntity.getPack_num(); i++) {
                if (i == 0) {
                    supperMapData = getMapCallbackEntities.get(0);
                } else {
                    if (supperMapData == null){
                        Log.e(TAG,"supperMapData 为空");
                    }
                    if (getMapCallbackEntities.get(i) == null){
                        Log.e(TAG,"getMapCallbackEntities.get(i) 为空");
                    }
                    supperMapData.getData().addAll(getMapCallbackEntities.get(i).getData());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
      //  Tools.showToast("整合完了");
        /*
        * 要优化 有耦合了
        * */
//        ThreadManager.getInstance().createLongPool().execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                ObtainMapManager.getInstance(supperMapData).loadMap(new ObtainMapManager.MapListenter() {
                    @Override
                    public void getMap(final Bitmap map) {

                        Log.e(TAG, "图片出来啦");
                        if (mapListenter != null){
                            mapListenter.getMap(map);
                        }
                    }

                    @Override
                    public void error(String message) {
                        Log.e(TAG,"出异常啦"+message);
                        // Tools.showToast(message);
                    }
                });
            }
        });
    }

    /*
     * 清空数据  等于重置
     * */
    public void cleanData() {
        countIndex = 0;
        getMapCallbackEntities.clear();
        tempEntitys.clear();
    }


    public interface HandlePackageListener {
        void nextPackage(int index);
    }
}
