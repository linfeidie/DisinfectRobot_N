package com.linfd.scri.disinfectrobot.entity;

import java.util.List;
import java.util.Objects;

/*
 * 地图参数数据
 * */
public class GetMapParamCallbackEntity extends TypeEntity {

  /**
   * height : 1728
   * id : e2baac1d-9ec5-4461--7b53e202bdf7
   * origin : [-77.2,-21.2,0]
   * pack_id : 0
   * pack_num : 342
   * resolution : 0.05000000074505806
   * to_id : b4f89c82-8d3f-4b15-b293-0c605678a537
   * width : 1728
   */

  private int height;
  private String id;
  private int pack_id;
  private int pack_num;
  private double resolution;
  private String to_id;
  private int width;
  private List<Double> origin;

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getPack_id() {
    return pack_id;
  }

  public void setPack_id(int pack_id) {
    this.pack_id = pack_id;
  }

  public int getPack_num() {
    return pack_num;
  }

  public void setPack_num(int pack_num) {
    this.pack_num = pack_num;
  }

  public double getResolution() {
    return resolution;
  }

  public void setResolution(double resolution) {
    this.resolution = resolution;
  }

  public String getTo_id() {
    return to_id;
  }

  public void setTo_id(String to_id) {
    this.to_id = to_id;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public List<Double> getOrigin() {
    return origin;
  }

  public void setOrigin(List<Double> origin) {
    this.origin = origin;
  }


}
