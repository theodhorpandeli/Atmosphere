package com.example.theodhor.airchecker.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Dori on 4/15/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable{

    @SerializedName("aqi")
    private Integer aqi;
    @SerializedName("description")
    private String description;
    @SerializedName("city")
    private String city;
    @SerializedName("address")
    private String address;
    @SerializedName("lat")
    private Double latitude;
    @SerializedName("lon")
    private Double longitude;
    @SerializedName("weather_summary")
    private String weatherSummary;
    @SerializedName("weather_time")
    private String weatherTime;
    @SerializedName("weather_icon")
    private String weatherIcon;
    @SerializedName("weather_temperature")
    private Double weatherTemperature;
    @SerializedName("panorama")
    private String panoramaUrl;
    @SerializedName("sensor_0")
    private Sensor_0 temperatureData;

    @SerializedName("sensor_1")
    private Sensor_1 carbonMonoxideData;

    @SerializedName("sensor_2")
    private Sensor_2 amoniumData;

    @SerializedName("sensor_3")
    private Sensor_3 hydrogenSulfideData;

    @SerializedName("sensor_4")
    private Sensor_4 sulfurDioxideData;

    @SerializedName("sensor_5")
    private Sensor_5 nitrogenDioxideData;

    @SerializedName("sensor_6")
    private Sensor_6 carbonDioxideData;

    @SerializedName("sensor_7")
    private Sensor_7 radiationData;

    @SerializedName("sensor_8")
    private Sensor_8 dustData;

    @SerializedName("sensor_9")
    private Sensor_9 noiseData;

    public Sensor_0 getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(Sensor_0 sensor0) {
        this.temperatureData = sensor0;
    }

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSensor_0(Sensor_0 sensor_0) {
        this.temperatureData = sensor_0;
    }

    public Sensor_1 getCarbonMonoxideData() {
        return carbonMonoxideData;
    }

    public void setCarbonMonoxideData(Sensor_1 carbonMonoxideData) {
        this.carbonMonoxideData = carbonMonoxideData;
    }

    public Sensor_2 getAmoniumData() {
        return amoniumData;
    }

    public void setAmoniumData(Sensor_2 amoniumData) {
        this.amoniumData = amoniumData;
    }

    public Sensor_3 getHydrogenSulfideData() {
        return hydrogenSulfideData;
    }

    public void setHydrogenSulfideData(Sensor_3 hydrogenSulfideData) {
        this.hydrogenSulfideData = hydrogenSulfideData;
    }

    public Sensor_4 getSulfurDioxideData() {
        return sulfurDioxideData;
    }

    public void setSulfurDioxideData(Sensor_4 sulfurDioxideData) {
        this.sulfurDioxideData = sulfurDioxideData;
    }

    public Sensor_5 getNitrogenDioxideData() {
        return nitrogenDioxideData;
    }

    public void setNitrogenDioxideData(Sensor_5 nitrogenDioxideData) {
        this.nitrogenDioxideData = nitrogenDioxideData;
    }

    public Sensor_6 getCarbonDioxideData() {
        return carbonDioxideData;
    }

    public void setCarbonDioxideData(Sensor_6 carbonDioxideData) {
        this.carbonDioxideData = carbonDioxideData;
    }

    public Sensor_7 getRadiationData() {
        return radiationData;
    }

    public void setRadiationData(Sensor_7 radiationData) {
        this.radiationData = radiationData;
    }

    public Sensor_8 getDustData() {
        return dustData;
    }

    public void setDustData(Sensor_8 dustData) {
        this.dustData = dustData;
    }

    public Sensor_9 getNoiseData() {
        return noiseData;
    }

    public void setNoiseData(Sensor_9 noiseData) {
        this.noiseData = noiseData;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getWeatherSummary() {
        return weatherSummary;
    }

    public void setWeatherSummary(String weatherSummary) {
        this.weatherSummary = weatherSummary;
    }

    public String getWeatherTime() {
        return weatherTime;
    }

    public void setWeatherTime(String weatherTime) {
        this.weatherTime = weatherTime;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Double getWeatherTemperature() {
        return weatherTemperature;
    }

    public void setWeatherTemperature(Double weatherTemperature) {
        this.weatherTemperature = weatherTemperature;
    }

    public String getPanoramaUrl() {
        return panoramaUrl;
    }

    public void setPanoramaUrl(String panoramaUrl) {
        this.panoramaUrl = panoramaUrl;
    }
}

