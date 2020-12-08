package com.linfd.scri.disinfectrobot.entity;

/*
 * 登录后返回
 * */
public class LoginCallbackEntity extends TypeEntity {

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
