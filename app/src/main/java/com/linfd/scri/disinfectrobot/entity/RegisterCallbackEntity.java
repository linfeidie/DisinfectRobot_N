package com.linfd.scri.disinfectrobot.entity;

public class RegisterCallbackEntity {

  /**
   * state : true
   * type : ser_ack_register
   */

  private String state;
  private String type;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
