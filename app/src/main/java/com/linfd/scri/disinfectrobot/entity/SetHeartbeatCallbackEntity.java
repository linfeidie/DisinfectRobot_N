package com.linfd.scri.disinfectrobot.entity;

/*
 * 心跳包返回
 * */
public class SetHeartbeatCallbackEntity extends TypeEntity {


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
