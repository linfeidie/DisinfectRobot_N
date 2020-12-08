package com.linfd.scri.disinfectrobot.entity;

/*
 * 心跳
 * */
public class SetHeartbeatEntity extends TypeEntity {

  /**
   * id : xxx
   */

  private String id;

  public SetHeartbeatEntity() {
    setType("set_heartbeat");
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
