package com.linfd.scri.disinfectrobot.entity;

import java.io.Serializable;

/**
 * 文件描述：.
 * <p>
 * 作者：Created by 林飞堞 on 2019/9/26
 * <p>
 * 版本号：donghaoProect
 */
public class TypeEntity implements Serializable {
  private static final long serialVersionUID = 1L;
  private String type;
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
