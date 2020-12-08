package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

/*
* 异常代码
*
"type":"exception_codes",//
"codes":[10010,.......],//异常代码
"stamps":[151324156,.......],//异常代码,时间戳,int,需要除以1000,转换为浮点,单位s
"nums":[1,.......],//异常代码,发生次数,int
"packs_num":1,//包数
"packs_id":0//包号
* */
public class ExceptionCodesCallbackEntity extends TypeEntity {


    /**
     * id : xxx
     * to_id : xxx
     * codes : [10010,10010]
     * stamps : [151324156,151324156]
     * nums : [1,2]
     * packs_num : 1
     * packs_id : 0
     */

    private String id;
    private String to_id;
    private int packs_num;
    private int packs_id;
    private List<Integer> codes;
    private List<Integer> stamps;
    private List<Integer> nums;

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

    public int getPacks_num() {
        return packs_num;
    }

    public void setPacks_num(int packs_num) {
        this.packs_num = packs_num;
    }

    public int getPacks_id() {
        return packs_id;
    }

    public void setPacks_id(int packs_id) {
        this.packs_id = packs_id;
    }

    public List<Integer> getCodes() {
        return codes;
    }

    public void setCodes(List<Integer> codes) {
        this.codes = codes;
    }

    public List<Integer> getStamps() {
        return stamps;
    }

    public void setStamps(List<Integer> stamps) {
        this.stamps = stamps;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }
}
