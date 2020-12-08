package com.linfd.scri.disinfectrobot.entity;

public class LoginEntity extends TypeEntity {

  /**
   * id : b4f89c82-8d3f-4b15-b293-0c605678a537
   * type : set_online
   * user_name : linfd
   * pass_word : 123456
   * mach_type : 0
   */

  private String id;
  private String user_name;
  private String pass_word;
  private int mach_type;

  public LoginEntity() {
    setType("set_online");
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getPass_word() {
    return pass_word;
  }

  public void setPass_word(String pass_word) {
    this.pass_word = pass_word;
  }

  public int getMach_type() {
    return mach_type;
  }

  public void setMach_type(int mach_type) {
    this.mach_type = mach_type;
  }

}
