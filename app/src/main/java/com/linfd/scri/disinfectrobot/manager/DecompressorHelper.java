package com.linfd.scri.disinfectrobot.manager;

import java.util.ArrayList;
import java.util.List;

/*
* 地图数据解压器 把压缩数据变成最原始数据
* */
public class DecompressorHelper {

    private List<Integer> OriginalData ;//解压后的原始数据
    private List<Integer> tempData = new ArrayList<>();//临时数据
    private static final DecompressorHelper ourInstance = new DecompressorHelper();

    public static DecompressorHelper getInstance() {
        return ourInstance;
    }

    private DecompressorHelper() {
    }
    /*
    * 核心方法
    * */
    public List<Integer> decompressData(List<Integer> compressData,int width,int height) {
        if (compressData == null || compressData.size() < 1 || width == 0 || height == 0){
            return null;
        }
        int count = 0;
        OriginalData = new ArrayList<>(width * height);
        for (int i = 0; i < compressData.size(); i++) {
            //获取数量
            if(i%2 ==0){
                count = compressData.get(i);
            }else{
                for (int j = 0; j < count ; j++) {
                    tempData.add(j,compressData.get(i));//测试 ObtainMapManager类加了synchronized 这里抛出过异常IndexOutOfBoundsException: Invalid index 93576, size is 326
                }
                OriginalData.addAll(tempData);
                //获取值
                tempData.clear();

            }

        }
        return OriginalData;
    }
}
