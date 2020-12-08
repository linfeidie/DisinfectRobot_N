package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

public class OnlineIdsCallbackEntity {

  /**
   * id_mach : [{"id":"b4f89c82-8d3f-4b15-b293-0c605678a537","type":0},{"id":"e2baac1d-9ec5-4461-a8fb-7b53e202bdf7","type":1}]
   * pack_count : 1
   * pack_num : 1
   * type : ser_ack_online_ids
   */

  private int pack_count;
  private int pack_num;
  private String type;
  private List<IdMachBean> id_mach;

  public int getPack_count() {
    return pack_count;
  }

  public void setPack_count(int pack_count) {
    this.pack_count = pack_count;
  }

  public int getPack_num() {
    return pack_num;
  }

  public void setPack_num(int pack_num) {
    this.pack_num = pack_num;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<IdMachBean> getId_mach() {
    return id_mach;
  }

  public void setId_mach(List<IdMachBean> id_mach) {
    this.id_mach = id_mach;
  }

  public static class IdMachBean {
    /**
     * id : b4f89c82-8d3f-4b15-b293-0c605678a537
     * type : 0
     */

    private String id;
    private int type;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    @Override
    public String toString() {
      return "IdMachBean{" +
              "id='" + id + '\'' +
              ", type=" + type +
              '}';
    }
  }
}
