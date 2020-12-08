package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

/*
 * 获取地图
 * */
public class GetMapEntity extends TypeEntity {

    /**
     * id : b4f89c82-8d3f-4b15-b293-0c605678a537
     * to_id : e2baac1d-9ec5-4461-a8fb-7b53e202bdf7
     * get_map_type : data
     * get_pack_num : [1,10]
     */

    private String id;
    private String to_id;
    private String get_map_type;
    private List<Integer> get_pack_num;

    public GetMapEntity() {
        setType("get_map");
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

    public String getGet_map_type() {
        return get_map_type;
    }

    public void setGet_map_type(String get_map_type) {
        this.get_map_type = get_map_type;
    }

    public List<Integer> getGet_pack_num() {
        return get_pack_num;
    }

    public void setGet_pack_num(List<Integer> get_pack_num) {
        this.get_pack_num = get_pack_num;
    }
}
