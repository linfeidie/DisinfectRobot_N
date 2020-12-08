package com.linfd.scri.disinfectrobot.entity;

import android.os.Parcel;

import com.linfd.scri.disinfectrobot.manager.ObtainRandom;

import java.util.Objects;

/**
 * 文件描述：.
 * <p>  用于传递数据分类的
 * 作者：Created by 林飞堞 on 2019/10/23
 * <p>
 * 版本号：donghaoProect
 */
public class DataEntity extends TypeEntity {
  //public String type;//传递的数据

  public String message;//携带的数据
  private int random = ObtainRandom.get();



  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DataEntity)) return false;
    DataEntity that = (DataEntity) o;
    return random == that.random &&
            getMessage().equals(that.getMessage());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMessage(), random);
  }
}
