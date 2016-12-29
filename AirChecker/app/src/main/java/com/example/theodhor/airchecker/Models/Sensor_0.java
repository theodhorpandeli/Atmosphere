package com.example.theodhor.airchecker.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Dori on 4/15/2016.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Sensor_0 implements Serializable{

    @SerializedName("unit")
    private String unit;
    @SerializedName("station_name_short")
    private String stationName;
    @SerializedName("limit_value")
    private String limitValue;
    @SerializedName("values")
    private List<Value> values = new ArrayList<Value>();
    @SerializedName("station_name_long")
    private String stationNameLong;
    public String getStationNameLong() {
        return stationNameLong;
    }
    public void setStationNameLong(String stationNameLong) {
        this.stationNameLong = stationNameLong;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getStationName() {
        return stationName;
    }
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    public String getLimitValue() {
        return limitValue;
    }
    public void setLimitValue(String limitValue) {
        this.limitValue = limitValue;
    }
    public List<Value> getValues() {
        return values;
    }
    public void setValues(List<Value> values) {
        this.values = values;
    }

}
