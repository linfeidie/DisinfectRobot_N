package com.linfd.scri.disinfectrobot.manager;

import com.linfd.scri.disinfectrobot.entity.ExceptionCodesCallbackEntity;
import com.linfd.scri.disinfectrobot.entity.ExceptionEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* 目标  传入异常代码数组集合 返回  异常对象集合
* */
public class ExceptionCodesHelper {

    private Map<Integer, String> exceptionCodes = new HashMap<>();

    /*部件集合
    * */
    private Map<Integer, String> components = new HashMap<>();

    public static ExceptionCodesHelper instance = new ExceptionCodesHelper();

    public ExceptionCodesHelper() {
        LoadComponents();
        LoadExceptionCodes();
    }

    /*
    * 加载部件数据
    * */
    private void LoadComponents(){
        components.put(99,"无");
        components.put(1,"SLAM");
        components.put(2,"左驱电机");
        components.put(3,"右驱电机");
        components.put(4,"激光雷达");
        components.put(5,"控制底板");
        components.put(6,"超声传感");
        components.put(7,"红外传感");
        components.put(8,"充电电池");
        components.put(9,"急停按钮");
        components.put(10,"碰撞传感");
        components.put(11,"视觉传感");
        components.put(12,"交互屏幕");
        components.put(13,"滚刷电机");
        components.put(14,"盘刷电机");
        components.put(15,"吸水电机");
        components.put(16,"吸尘电机");
        components.put(17,"容器状态");
        components.put(18,"跌落传感");
        //components.put(19,"");
        components.put(20,"消毒传感");
        components.put(21,"空气过滤");
        components.put(22,"视频传感");
        components.put(23,"惯性传感");
        components.put(24,"底层通讯");
        components.put(25,"对接充电");
        components.put(26,"函数参数");
        components.put(27,"更换设备");
    }
    /*
    * 加载异常
    * */
    private void LoadExceptionCodes() {
        exceptionCodes.put(99999, "暂无异常");
        exceptionCodes.put(10101, "机器人定位出现丢失或定位跳跃现象");
        exceptionCodes.put(10102, "无法找到地图或地图解析错误");
        exceptionCodes.put(20103, "机器人处于障碍物内,或无地图区域,有可能机器人初始位置不正确,无法定位,请进行人工标定");
        exceptionCodes.put(20104, "路径查找失败");
        exceptionCodes.put(20201, "过载");
        exceptionCodes.put(20202, "过流");
        exceptionCodes.put(20203, "欠压");
        exceptionCodes.put(10204, "通讯异常");
        exceptionCodes.put(20301, "过载");
        exceptionCodes.put(20302, "过流");
        exceptionCodes.put(20303, "欠压");
        exceptionCodes.put(10304, "通讯异常");
        exceptionCodes.put(10401, "激光雷达通讯异常,请检查连接线路");
        exceptionCodes.put(10402, "激光雷达开启失败");
        exceptionCodes.put(10403, "激光雷达关闭失败");
        exceptionCodes.put(10501, "工控机与地板通讯异常,请检查地板通讯线路");
        exceptionCodes.put(20601, "通讯异常");
        exceptionCodes.put(20701, "通讯异常");
        exceptionCodes.put(10801, "电压偏低或偏高");
        exceptionCodes.put(20802, "电量低于10%,应进行充电");
        exceptionCodes.put(10803, "获取不了电量或电压");
        exceptionCodes.put(10804, "充电电压异常,偏高或偏低");
        exceptionCodes.put(20901, "急停按钮被按下");
        exceptionCodes.put(11001, "碰撞传感器长期处于触发状态,请检查碰撞传感器是否有损害或异物卡住");
        exceptionCodes.put(21101, "请检查视觉传感器线路");
        exceptionCodes.put(21201, "请检查交互屏幕的线路");
        exceptionCodes.put(21301, "过载");
        exceptionCodes.put(21302, "电机无法开启或通讯异常,请检测电机连线");
        exceptionCodes.put(21401, "过载");
        exceptionCodes.put(21402, "电机无法开启或通讯异常,请检测电机连线");
        exceptionCodes.put(21501, "过载");
        exceptionCodes.put(21502, "电机无法开启或通讯异常,请检测电机连线");
        exceptionCodes.put(21601, "过载");
        exceptionCodes.put(21602, "电机无法开启或通讯异常,请检测电机连线");
        exceptionCodes.put(21701, "清洁车,清水槽已空");
        exceptionCodes.put(21702, "清洁车,清水槽满");
        exceptionCodes.put(21703, "清洁车,污水已满");
        exceptionCodes.put(21704, "消毒车,蓄水箱水位低");
        exceptionCodes.put(21705, "消毒车,蓄水箱水位高");
        exceptionCodes.put(21706, "消毒车,雾化箱,水位低");
        exceptionCodes.put(21707, "消毒车,雾化箱,水位高");
        exceptionCodes.put(11801, "机器跌");
        exceptionCodes.put(21901, "水位低");
        exceptionCodes.put(21902, "水位高");
        exceptionCodes.put(12001, "过氧化氢传感器没有信号");
        exceptionCodes.put(22101, "过滤器阻塞");
        exceptionCodes.put(12102, "过滤器工作异常");
        exceptionCodes.put(12201, "摄像头工作异常");
        exceptionCodes.put(22202, "摄像头帧率不稳定或偏低");
        exceptionCodes.put(22301, "陀螺仪传感器发送频率偏低");
        exceptionCodes.put(12302, "陀螺仪无数据输出,或数据接收不正确");
        exceptionCodes.put(12303, "陀螺仪启动失败");
        exceptionCodes.put(12401, "串口开启失败");
        exceptionCodes.put(12402, "底层串口读取超时");
        exceptionCodes.put(12403, " 底层串口写超时");
        exceptionCodes.put(12404, "发送错误格式的协议");
        exceptionCodes.put(12405, "接收错误格式的协议");
        exceptionCodes.put(22402, "底层串口读取超时");
        exceptionCodes.put(22501, "机器人对接充电座超过三次不成功,提示该警告");
        exceptionCodes.put(22601, "某个函数的输入参数错误");
        exceptionCodes.put(22701, "前滚刷,已到使用期限");
        exceptionCodes.put(22702, "圆形盘刷,已到使用期限");
        exceptionCodes.put(22703, "吸尘滤网,已到使用期限");

    }

    public String findComponentById(){
        return "";
    }
    /*
    * 对外暴露的方法
    * */
    public List<ExceptionEntity> obtainExceptionEntitys(ExceptionCodesCallbackEntity callbackEntity){

        List<ExceptionEntity> entities = new ArrayList<>();
        for (int i = 0; i < callbackEntity.getCodes().size(); i++) {
            ExceptionEntity entity = new ExceptionEntity();
            Integer code = callbackEntity.getCodes().get(i);
            entity.setNumber(code);
            entity.setExplain(exceptionCodes.get(code));
            entity.setComponent(components.get(Integer.valueOf(code.toString().substring(1,3))));
            entity.setDegree(Integer.valueOf(code.toString().substring(0,1)));
            entity.setKind(Integer.valueOf(code.toString().substring(3,5)));
            entity.setNums(callbackEntity.getNums().get(i));
            entity.setStamps(callbackEntity.getStamps().get(i));
            entities.add(entity);
        }
        return entities;
    }
}
