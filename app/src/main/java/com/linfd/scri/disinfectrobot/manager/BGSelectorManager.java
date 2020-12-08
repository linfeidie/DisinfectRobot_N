package com.linfd.scri.disinfectrobot.manager;


import com.linfd.scri.disinfectrobot.Contanst;
import com.linfd.scri.disinfectrobot.tools.Tools;

import java.io.File;
import java.util.List;

/*
* 背景地图选择器
* 用最新的地图还是历史地图
* */
public class BGSelectorManager {

    public static volatile BGSelectorManager ourInstance;
    private MapWhen mapWhen = MapWhen.CURRENT;

    public static BGSelectorManager getInstance(){
        if (ourInstance == null){
            synchronized (BGSelectorManager.class){
                if (ourInstance == null){
                    ourInstance = new BGSelectorManager();
                }
            }
        }
        return ourInstance;
    };

    public BGSelectorManager() {

    }
/*
* 初始化 切换模式
* */
    public void toggle(MapWhen mapWhen){
        this.mapWhen = mapWhen;
    }

    public File getBGFile(){
        File file = null;
        if (mapWhen == MapWhen.CURRENT){
            file = new File(Contanst.CACHE_DIR, Contanst.map_time+".png");
        }else if (mapWhen == MapWhen.HISTORY){
            file = new File(Contanst.HISTORY_ORIGINAL_DIR, Tools.obtainHistoryFileName());
        }

        return file;
    }
    enum MapWhen{
        CURRENT(1),HISTORY(2);

        MapWhen(int value) {
        }
        
    }
    public List<Integer> getMapWH(){
        return Tools.getMapWH(getBGFile().getAbsolutePath());
    }

}
