package com.linfd.scri.disinfectrobot.entity;

/*
* 异常实体
* */
public class ExceptionEntity {

    /*
    编号
    * */
    private int number;

    /*
    * 错误警告
    * */
    private int degree;

    /*
    * 部件
    * */
    private String component;

    /*
    * 类型
    * */
    private int kind;

    /*
    * 说明
    * */
    private String explain;

    /*
    * 异常次数
    * */
    private int nums;

    /*
    * 时间戳
    * */

    private int stamps;

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getStamps() {
        return stamps;
    }

    public void setStamps(int stamps) {
        this.stamps = stamps;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Override
    public String toString() {
        return "ExceptionEntity{" +
                "number=" + number +
                ", degree=" + degree +
                ", component='" + component + '\'' +
                ", kind=" + kind +
                ", explain='" + explain + '\'' +
                '}';
    }
}
