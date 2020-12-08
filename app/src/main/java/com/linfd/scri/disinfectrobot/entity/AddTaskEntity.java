package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

/*
* 添加任务
* */
public class AddTaskEntity extends BaseEntity {

    private List<Integer> data;

    public List<Integer> getData() {
        return data;
    }

    public void setId(List<Integer> data) {
        this.data = data;
    }
}
