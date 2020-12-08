package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Bitmap;
import android.util.Log;


import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.entity.GetMapCallbackEntity;

import java.util.List;


/**
 * 文件描述：.和work项目有小修改，接收不是MapdataEntity
 * <p>作用，把非解压数据变成最原始数据，转成bitmap 存储和回调
 * 作者：Created by 林飞堞 on 2019/9/29
 * <p>
 * 版本号：Socket_learning
 */
public class ObtainMapManager {

    private List<Integer> OriginalData ;//解压后的原始数据
    private GetMapCallbackEntity mMapdata;//超级data
    private int height;
    private int width;



    public static ObtainMapManager getInstance(GetMapCallbackEntity getMapCallbackEntitie) {
        return new ObtainMapManager(getMapCallbackEntitie) ;
    }

    private ObtainMapManager(GetMapCallbackEntity mapdata) {
        this.mMapdata = mapdata;
        Log.e("lind","开始申请");
        width = Contanst.MAPPARAMENTITY.getWidth();
        height = Contanst.MAPPARAMENTITY.getHeight();
    }

    public  void loadMap(MapListenter mapListenter){
        //还原数据
        OriginalData = DecompressorHelper.getInstance().decompressData(mMapdata.getData(),width,height);
        if(OriginalData != null){
            //画点
            DrawBitmapHelper.getInstance().drawBitmap(OriginalData,width ,height,mapListenter);
        }else{
            mapListenter.error("解压地图数据异常");
        }

    }

    public interface  MapListenter{
        void getMap(Bitmap map);
        void error(String message);
    }
}
