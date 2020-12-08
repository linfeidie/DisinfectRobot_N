package com.linfd.scri.disinfectrobot.entity;


/*
 * 获取ids指令
 * */
public class OnlineIdsEntity extends TypeEntity{

  /**
   * id : b4f89c82-8d3f-4b15-b293-0c605678a537
   * type : get_online_ids
   */

  private String id;

  public OnlineIdsEntity() {
    setType("get_online_ids");
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
