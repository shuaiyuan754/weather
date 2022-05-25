package com.example.weather.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Administrator
 * @creat time 2022/5/25 14:50
 * description:
 **/
public class WeatherBean {
    @SerializedName("cityid")
    private String cityId;
    @SerializedName("city")
    private String city;
    @SerializedName("update_time")
    private String updateTime;
    @SerializedName("data")
    private List<DayWeatherBean> dayWeatherBeanList;

    public WeatherBean() {
    }

    public WeatherBean(String cityId, String city, String updateTime, List<DayWeatherBean> dayWeatherBeanList) {
        this.cityId = cityId;
        this.city = city;
        this.updateTime = updateTime;
        this.dayWeatherBeanList = dayWeatherBeanList;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<DayWeatherBean> getDayWeatherBeanList() {
        return dayWeatherBeanList;
    }

    public void setDayWeatherBeanList(List<DayWeatherBean> dayWeatherBeanList) {
        this.dayWeatherBeanList = dayWeatherBeanList;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "cityId='" + cityId + '\'' +
                ", city='" + city + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", dayWeatherBeanList=" + dayWeatherBeanList +
                '}';
    }
}
