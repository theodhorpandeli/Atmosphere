package com.example.theodhor.airchecker.Connection;

import com.example.theodhor.airchecker.Models.Data;
import com.example.theodhor.airchecker.Models.Sensor_0;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Dori on 4/14/2016.
 */
public interface Interface {

    @GET("/index.php")
    void getData(Callback<Data> callback);
}
