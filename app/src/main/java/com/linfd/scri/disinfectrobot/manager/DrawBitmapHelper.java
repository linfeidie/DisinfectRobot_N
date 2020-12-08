package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;


import com.linfd.scri.disinfectrobot.tools.Tools;

import java.util.List;

public class DrawBitmapHelper {
    private static final DrawBitmapHelper ourInstance = new DrawBitmapHelper();

    public static DrawBitmapHelper getInstance() {
        return ourInstance;
    }

    private DrawBitmapHelper() {
    }

    //根据队列里存储的数据描点
    public boolean drawBitmap(List<Integer> OriginalData,int width, int height,ObtainMapManager.MapListenter mapListenter) {

        int index = 0 ;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        try {
            for (int i = 0; i < height-1; i++) {
                for (int j = 0; j < width-1 ; j++) {
                    index = i * width + j;
                    int color = Color.GREEN;
                    if(OriginalData.get(index) == -1) {
                        color = Color.GRAY;
                    }else if(OriginalData.get(index) == 0) {
                        color = Color.WHITE;
                    }else if(OriginalData.get(index) == 100) {
                        color = Color.BLACK;
                    }
                    try {
                        bitmap.setPixel(j, i, color);
                    } catch (Exception e) {
                        Tools.showToast("地图异常");
                        mapListenter.error("地图异常"+e.toString());
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("lind","数据还原异常");
            mapListenter.error("数据还原异常");
            return false;
        }
        if(bitmap != null && mapListenter != null) {
            mapListenter.getMap(bitmap);
            //加入缓存  原始不带路径的
            ImageHelper.cacheBitmap(bitmap);
        }
        return true;
    }
}
