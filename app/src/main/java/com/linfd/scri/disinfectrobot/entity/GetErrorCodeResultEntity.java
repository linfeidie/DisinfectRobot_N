package com.linfd.scri.disinfectrobot.entity;

import java.util.ArrayList;
import java.util.List;

/*
 * 解析后的异常实体
 * */
public class GetErrorCodeResultEntity {
    //public List<GetErrorCodeEntity.InfoBean.HanxinBean.Yg00a00020071211000n00Bean.ZhCnBeanX> hanxins = new ArrayList<>();//韩信
    public List<GetErrorCodeEntity.InfoBean.ChargingStationBean.Cj02Bean.ZhCnBean> charges = new ArrayList<>();//充电桩
    public List<GetErrorCodeEntity.InfoBean.YugongBean.Yg00sh8020103119000000Bean.ZhCnBeanX> yugongs;//
}
