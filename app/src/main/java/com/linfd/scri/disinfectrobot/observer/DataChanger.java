package com.linfd.scri.disinfectrobot.observer;


import com.linfd.scri.disinfectrobot.entity.DataEntity;

import java.util.Observable;


/**
 * 文件描述：.
 * <p> 被观察者
 * 作者：Created by 林飞堞 on 2019/10/23
 * <p>
 * 版本号：donghaoProect
 */
public class DataChanger extends Observable {
  private static volatile DataChanger ourInstance ;
  private DataEntity dataEntity ;

  public static DataChanger getInstance() {
    if(ourInstance == null) {
      synchronized (DataChanger.class){
        if(ourInstance == null) {
          ourInstance = new DataChanger();
        }
      }
    }
    return ourInstance;
  }

  private DataChanger() {
    dataEntity = new DataEntity();
  }
  /*
   * SourceDataString  服务端返回的json数据
   * */
  public void postData(DataEntity dataEntity){
    setChanged();
    notifyObservers(dataEntity);
  }
}
