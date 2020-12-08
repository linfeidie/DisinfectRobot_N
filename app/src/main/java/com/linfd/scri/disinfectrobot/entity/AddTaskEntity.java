package com.linfd.scri.disinfectrobot.entity;

import java.util.List;

/*
* 添加任务
* */
public class AddTaskEntity extends BaseEntity {

    private List<Integer> id;

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }
}
