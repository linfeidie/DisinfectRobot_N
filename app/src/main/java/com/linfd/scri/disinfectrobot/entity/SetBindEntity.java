package com.linfd.scri.disinfectrobot.entity;

/*
 * 绑定小车
 * */

public class SetBindEntity extends TypeEntity {

  /**
   * id : b4f89c82-8d3f-4b15-b293-0c605678a537
   * bind_id : e2baac1d-9ec5-4461-a8fb-7b53e202bdf7
   */

  private String id;
  private String bind_id;

  public SetBindEntity() {
    setType("set_bind");
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBind_id() {
    return bind_id;
  }

  public void setBind_id(String bind_id) {
    this.bind_id = bind_id;
  }
}
