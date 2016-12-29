package com.example.theodhor.airchecker.Connection;

import android.util.Log;

import com.example.theodhor.airchecker.Models.Data;
import com.squareup.otto.Produce;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Dori on 4/14/2016.
 */
public class Communicator {
    private static final String BASE_URL = "http://46.101.143.44/api";

    public void getData() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        Interface anInterface = restAdapter.create(Interface.class);
        Callback<Data> callback = new Callback<Data>() {
            @Override
            public void success(Data data, Response response) {
                if (data.getTemperatureData().getValues().size()> 0) {
                    BusProvider.getInstance().post(produceResponseEvent(data));
                } else {
                    BusProvider.getInstance().post(produceErrorEvent(-100,response.getReason()));
                }
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
                BusProvider.getInstance().post(produceErrorEvent(-100,error.toString()));
            }
        };
        anInterface.getData(callback);
    }

    @Produce
    public ResponseEvent produceResponseEvent(Data data){
        return new ResponseEvent(data);
    }

    @Produce
    public ErrorEvent produceErrorEvent(int errorCode, String errorMessage){
        return new ErrorEvent(errorCode,errorMessage);
    }
}
