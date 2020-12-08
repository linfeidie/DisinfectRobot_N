package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;


import com.linfd.scri.disinfectrobot.BaseApplication;
import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.FileControl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageHelper {

    /**
     * 保存bitmap到本地
     *
     * @param path    路径
     * @param mBitmap 图片
     * @return 路径
     */
    private static boolean saveBitmap(String path, Bitmap mBitmap) {

        if (!TextUtils.isEmpty(ObtainStatusStamp.instacne.map_update) ) {
            File file = new File(path, Contanst.map_time + ".png");
            Log.e("linfd", file.getAbsolutePath());
            if (!file.exists()) {
                try {
                    boolean b1 = file.getParentFile().getParentFile().mkdir();
                    boolean b = file.getParentFile().mkdir();
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            try {
                FileOutputStream fos = new FileOutputStream(file);
                mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        return true;

    }

    /*
     * 保存历史路径地图
     * */

    public static boolean historyPathBitmap(Bitmap mBitmap) {
        return saveBitmap(BaseApplication.getApplication().getExternalFilesDir("historyPath").getAbsolutePath(), mBitmap);//BaseApplication.getApplication().getFilesDir().getAbsolutePath()
    }

    /*
     * 保存历史地图
     * */
    public static boolean historyOriginalBitmap(){
        String path = Contanst.CACHE_DIR;
        File file = new File(path, Contanst.map_time + ".png");
        String path2 = Contanst.HISTORY_ORIGINAL_DIR;
        File file2 = new File(path2, file.getName());
        try {
            FileControl.copyFile(file.getAbsolutePath(),file2.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /*
     * 保存缓存路径地图
     * */
    public static boolean cacheBitmap(Bitmap mBitmap) {

        return saveBitmap(Contanst.CACHE_DIR, mBitmap);
    }



}
