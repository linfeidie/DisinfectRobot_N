package com.linfd.scri.disinfectrobot.entity;

/*
 * 下线返回
 * */
public class AckOfflineCallbackEntity extends TypeEntity {

  /**
   * state : true
   */

  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
