package com.linfd.scri.disinfectrobot.entity;

import android.os.Parcel;
import android.os.Parcelable;

/*
* 用于传递地图数据信息
* */
public class MapInfoBean implements Parcelable {

    private String path;
    private String map_update;
    private String file_name;
    private String wor_time;

    public MapInfoBean() {
    }

    protected MapInfoBean(Parcel in) {
        path = in.readString();
        map_update = in.readString();
        file_name = in.readString();
        wor_time = in.readString();
    }

    public static final Creator<MapInfoBean> CREATOR = new Creator<MapInfoBean>() {
        @Override
        public MapInfoBean createFromParcel(Parcel in) {
            return new MapInfoBean(in);
        }

        @Override
        public MapInfoBean[] newArray(int size) {
            return new MapInfoBean[size];
        }
    };

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMap_update() {
        return map_update;
    }

    public void setMap_update(String map_update) {
        this.map_update = map_update;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getWor_time() {
        return wor_time;
    }

    public void setWor_time(String wor_time) {
        this.wor_time = wor_time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(path);
        parcel.writeString(map_update);
        parcel.writeString(file_name);
        parcel.writeString(wor_time);
    }
}
