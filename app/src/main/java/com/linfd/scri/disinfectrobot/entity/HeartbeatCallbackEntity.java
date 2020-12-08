package com.linfd.scri.disinfectrobot.entity;

/*
 * 服务器心跳返回
 * */
public class HeartbeatCallbackEntity extends TypeEntity {

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
