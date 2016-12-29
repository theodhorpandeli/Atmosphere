package com.example.theodhor.airchecker;

import android.graphics.Color;

import com.example.theodhor.airchecker.Models.Data;

/**
 * Created by Dori on 4/16/2016.
 */
public class Parameter {
    public String parameterName;
    public String parameterValue;
    public String parameterUnit;
    public Integer sensorId;
    public Data data;
    public Float limit;

    public Parameter(String parameterName, String parameterValue, String parameterUnit, Integer sensorId, Data data, Float limit) {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
        this.parameterUnit = parameterUnit;
        this.sensorId = sensorId;
        this.data = data;
        this.limit = limit;
    }
}
