package com.linfd.scri.disinfectrobot.entity;

/*
 * 设置模式
 * */
public class SetWorkModeEntity extends TypeEntity {

  /**
   * id : b4f89c82-8d3f-4b15-b293-0c605678a537
   * to_id : 2b9074f9-7b57-47f6-9031-3a09a4486ffa
   * work_mode : manual
   */

  private String id;
  private String to_id;
  private String work_mode;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTo_id() {
    return to_id;
  }

  public void setTo_id(String to_id) {
    this.to_id = to_id;
  }

  public String getWork_mode() {
    return work_mode;
  }

  public void setWork_mode(String work_mode) {
    this.work_mode = work_mode;
  }
}
