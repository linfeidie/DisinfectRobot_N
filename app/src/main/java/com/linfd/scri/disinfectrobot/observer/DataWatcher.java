package com.linfd.scri.disinfectrobot.observer;


import com.linfd.scri.disinfectrobot.entity.TypeEntity;

import java.util.Observable;
import java.util.Observer;


/**
 * 文件描述：.
 * <p>  观察者
 * 作者：Created by 林飞堞 on 2019/10/23
 * <p>
 * 版本号：donghaoProect
 */
public abstract class DataWatcher implements Observer {
    public static final String TAG = DataWatcher.class.getSimpleName();

    @Override
    public void update(Observable observable, Object o) {

        if(o instanceof TypeEntity) {
            notifyUpdata(o);
        }
    }
    public abstract void notifyUpdata( Object o) ;
}
