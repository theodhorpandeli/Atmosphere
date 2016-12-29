package com.example.theodhor.airchecker.Connection;

import com.example.theodhor.airchecker.Models.Data;
import com.example.theodhor.airchecker.Models.Sensor_0;

/**
 * Created by Dori on 4/15/2016.
 */
public class ResponseEvent {
    private Data dataList;

    public ResponseEvent(Data dataListItem) {
        this.dataList = dataListItem;
    }

    public Data getDataList() {
        return dataList;
    }

    public void setDataList(Data dataListItem) {
        this.dataList = dataListItem;
    }
}
