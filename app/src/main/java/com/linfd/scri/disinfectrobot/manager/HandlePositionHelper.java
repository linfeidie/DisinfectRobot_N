package com.linfd.scri.disinfectrobot.manager;

import android.graphics.Rect;
import android.util.Log;


import com.linfd.scri.disinfectrobot.Contanst;

import java.util.List;

/*
 * 根据后台返回来的位置转换成可用用在地图上的Rect对象
 * 隔离业务
 * */
public class HandlePositionHelper {

    private static Rect mrect;
    public static final String TAG = HandlePositionHelper.class.getSimpleName();
    public static Rect handle(List<Double> serverPos){
        /*
        * 防止崩溃
        * */
        if (serverPos == null || serverPos.size() <= 0){
            Log.e(TAG,"空拉");
        }
        if (Contanst.MAPPARAMENTITY == null && Contanst.MAPPARAMENTITY.getOrigin() != null && Contanst.MAPPARAMENTITY.getOrigin().size()>0){
            return null;
        }
//        int width = BGSelectorManager.getInstance().getMapWH().get(0);
//        int height = BGSelectorManager.getInstance().getMapWH().get(1);
        int width = Contanst.MAPPARAMENTITY.getWidth();
        int height = Contanst.MAPPARAMENTITY.getHeight();

        double left = height - (-(Contanst.MAPPARAMENTITY.getOrigin().get(1) - serverPos.get(1)) / Contanst.MAPPARAMENTITY.getResolution());
        double top = width - (-(Contanst.MAPPARAMENTITY.getOrigin().get(0) - serverPos.get(0)) / Contanst.MAPPARAMENTITY.getResolution());
        mrect = new Rect();
        mrect.left = (int) left;
        mrect.top = (int) top;
       // Tools.showToast(mrect.left+"=="+mrect.top);
        return mrect;
    }


}
