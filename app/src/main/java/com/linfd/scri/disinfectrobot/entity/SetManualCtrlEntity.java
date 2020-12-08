package com.linfd.scri.disinfectrobot.entity;

/*
 * 手动控制模式
 * */
public class SetManualCtrlEntity extends TypeEntity {


  /**
   * id : b4f89c82-8d3f-4b15-b293-0c605678a537
   * to_id : e2baac1d-9ec5-4461-a8fb-7b53e202bdf7
   * linear_speed : 0.0
   * angular_speed : 0.3
   * timeout : 1.0
   * dist : 0.0
   * angle : 0.0
   */

  private String id;
  private String to_id;
  private double linear_speed;
  private double angular_speed;
  private int man_switch;
//  private double timeout;
//  private double dist;
//  private double angle;


  public int getMan_switch() {
    return man_switch;
  }

  public void setMan_switch(int man_switch) {
    this.man_switch = man_switch;
  }

  public SetManualCtrlEntity() {
    setType("set_manual_ctrl");
  }

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

  public double getLinear_speed() {
    return linear_speed;
  }

  public void setLinear_speed(double linear_speed) {
    this.linear_speed = linear_speed;
  }

  public double getAngular_speed() {
    return angular_speed;
  }

  public void setAngular_speed(double angular_speed) {
    this.angular_speed = angular_speed;
  }


}
