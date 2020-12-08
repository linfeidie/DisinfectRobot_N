package com.linfd.scri.disinfectrobot.entity;

import java.util.List;
/*
* 地图返回包数据
* */

public class GetMapCallbackEntity extends TypeEntity {

    /**
     * data : [1,0,354,-1,4,0,14,100,1,0,19,-1,9,100,259,0,7,100,17,0,2,100,39,-1,6,0,25,-1,2,0,1,100,221,-1,3,0,16,-1,5,0,1,-1,3,0,3,-1,1,0,2,-1,1,0,11,-1,11,0,659,-1,10,0,8,-1,1,0,4,-1,8,0,1,100,348,-1,6,0,16,-1,3,100,26,-1,11,100,255,0,2,100,17,0,1,100,1,0,41,-1,5,0,19,-1,5,0,224,-1,4,0,15,-1,5,0,1,-1,3,0,3,-1,1,0,2,-1,1,0,11,-1,10,0,660,-1,10,0,8,-1,1,0,4,-1,9,0,342,-1,6,0,59,-1,11,100,266,0,1,100,2,0,41,-1,4,0,14,-1,5,0,230,-1,4,0,14,-1,5,0,1,-1,3,0,3,-1,1,0,2,-1,1,0,10,-1,9,0,1,100,1,0,1,100,659,-1,9,0,1,100,8,-1,1,0,3,-1,9,0,337,-1,6,0,72,-1,11,100,259,0,4,100,1,0,41,-1,3,0,7,-1,6,0,235,-1,4,0,15,-1,4,0,1,-1,3,0,3,-1,1,0,2,-1,1,0,10,-1,9,0,1,100,1,-1,1,0,659,-1]
     * data_len : 256
     * id : e2baac1d-9ec5-4461-a8fb-7b53e202bdf7
     * pack_count : 10
     * pack_id : 0
     * to_id : b4f89c82-8d3f-4b15-b293-0c605678a537
     */

    private int data_len;
    private String id;
    private int pack_count;
    private int pack_id;
    private String to_id;
    private List<Integer> data;

    public int getData_len() {
        return data_len;
    }

    public void setData_len(int data_len) {
        this.data_len = data_len;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPack_count() {
        return pack_count;
    }

    public void setPack_count(int pack_count) {
        this.pack_count = pack_count;
    }

    public int getPack_id() {
        return pack_id;
    }

    public void setPack_id(int pack_id) {
        this.pack_id = pack_id;
    }

    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
