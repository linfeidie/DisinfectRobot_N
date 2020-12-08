package com.linfd.scri.disinfectrobot.entity;
/*
* 记录x，y坐标点
* */
public class CoordinateEntity {
    public float x;
    public float y;

    public CoordinateEntity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "CoordinateEntity{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
