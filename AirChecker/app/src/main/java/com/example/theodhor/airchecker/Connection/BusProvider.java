package com.example.theodhor.airchecker.Connection;

/**
 * Created by Dori on 4/14/2016.
 */
import com.squareup.otto.Bus;

public class BusProvider {

    private static final Bus BUS = new Bus(); // me lib

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}
}

