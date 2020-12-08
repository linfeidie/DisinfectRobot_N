package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Bitmap;
import android.util.Log;

import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.tools.GsonUtil;
import com.linfd.scri.disinfectrobot.tools.Tools;
import com.linfd.scri.disinfectrobot.entity.DataEntity;
import com.linfd.scri.disinfectrobot.entity.GetMapCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.GetMapParamCallbackEntity;
import com.linfd.scri.disinfectrobot.eventbus.Event2;
import com.linfd.scri.disinfectrobot.observer.DataChanger;
import com.linfd.scri.disinfectrobot.observer.DataWatcher;

import org.greenrobot.eventbus.EventBus;


/*
* 获取地图数据的封装类
* 负责发送指令和接受数据  不负责解析
* */
public class MapDataObtainManager {

    public static  String TAG = MapDataObtainManager.class.getSimpleName();

    private static MapDataObtainManager instance;
    private GetMapParamCallbackEntity getMapParamCallbackEntity; //返回来的地图参数
    private ObtainMapManager.MapListenter mapListenter;//回调给上层



    private DataWatcher watcher= new DataWatcher(){
        @Override
        public void notifyUpdata(Object data) {
            if (data instanceof DataEntity) {
                DataEntity dataEntity = (DataEntity) data;
                if (dataEntity.getType().equalsIgnoreCase(Contanst.map_data)) {
                    Log.e("linfd", "地图数据");
                    acceptMapData(GsonUtil.GsonToBean(dataEntity.getMessage(), GetMapCallbackEntity.class));
                }else if (dataEntity.getType().equalsIgnoreCase(Contanst.map_param)) {
                    Log.e("linfd", "地图数据参数");
                    getMapParamCallbackEntity = GsonUtil.GsonToBean(dataEntity.getMessage(),GetMapParamCallbackEntity.class);
                    if (getMapParamCallbackEntity != null){
                        HandleSubpackageManager.getInstance().setMapParam(getMapParamCallbackEntity);
                        //在这里判断地图宽高是否变化了   发消息
                        if (Contanst.MAPPARAMENTITY != null && (Contanst.MAPPARAMENTITY.getHeight() != getMapParamCallbackEntity.getHeight() || Contanst.MAPPARAMENTITY.getWidth() != getMapParamCallbackEntity.getWidth())){
                            Tools.showToast("宽高发生变化了");
                            Event2 entity = new Event2();
                            EventBus.getDefault().post(entity);
                        }
                        Contanst.MAPPARAMENTITY = getMapParamCallbackEntity;//测试
                        Contanst.map_time = ObtainStatusStamp.instacne.map_update;


                        //拿到参数，自动获取地图数据
                        getMap(0);//从 1 开始
                    }
                }
            }
        }
    };

    /*
     * 实现它可以得到地图
     * */
    public void setMapListenter(ObtainMapManager.MapListenter mapListenter){
        this.mapListenter = mapListenter;
    }
    public static MapDataObtainManager getInstance(){
        if (instance == null){
            synchronized (MapDataObtainManager.class){
                if (instance == null){
                    instance = new MapDataObtainManager();
                }
            }
        }
        return instance;
    }

    public MapDataObtainManager() {
        DataChanger.getInstance().addObserver(watcher);
    }

    public void start(){
        /* 1
        * 清空
        * */
        HandleSubpackageManager.getInstance().cleanData();
        /* 2
        * 获取地图参数
        * */
        UdpControlSendManager.getInstance().get_map_param(Contanst.id,Contanst.to_id);

    }

    /*
     * 接收地图数据
     * */
    private void acceptMapData(GetMapCallbackEntity getMapCallbackEntity) {
        HandleSubpackageManager.getInstance().handerMap(getMapCallbackEntity, new HandleSubpackageManager.HandlePackageListener() {
            @Override
            public void nextPackage(int index) {
                int k = index+Contanst.REQUEST_MAPPACK_COUNT -1;
                UdpControlSendManager.getInstance().get_map(Contanst.id,Contanst.to_id,index,k);

            }
        });
        HandleSubpackageManager.getInstance().setMapListenter(new ObtainMapManager.MapListenter() {
            @Override
            public void getMap(Bitmap map) {
                if (mapListenter != null){
                    mapListenter.getMap(map);
                }
            }

            @Override
            public void error(String message) {
                mapListenter.error(message);
            }
        });
    }

    /*
    * 请求地图数据
    * index 包的开始序号
    * */
    public void getMap(int index){
        UdpControlSendManager.getInstance().get_map(Contanst.id,Contanst.to_id,index,index + Contanst.REQUEST_MAPPACK_COUNT -1);
    }

}
