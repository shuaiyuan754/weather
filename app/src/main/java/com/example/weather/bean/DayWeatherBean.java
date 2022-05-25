package com.example.weather.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Administrator
 * @creat time 2022/5/25 14:56
 * description:
 **/
public class DayWeatherBean {
    @SerializedName("date")
    private String date;
    @SerializedName("wea")
    private String wea;
    @SerializedName("wea_img")
    private String weaImg;
    @SerializedName("tem_day")
    private String temDay;
    @SerializedName("tem_night")
    private String temNight;
    @SerializedName("win")
    private String win;
    @SerializedName("win_speed")
    private String winSpeed;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }

    public String getWeaImg() {
        return weaImg;
    }

    public void setWeaImg(String weaImg) {
        this.weaImg = weaImg;
    }

    public String getTemDay() {
        return temDay;
    }

    public void setTemDay(String temDay) {
        this.temDay = temDay;
    }

    public String getTemNight() {
        return temNight;
    }

    public void setTemNight(String temNight) {
        this.temNight = temNight;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getWinSpeed() {
        return winSpeed;
    }

    public void setWinSpeed(String winSpeed) {
        this.winSpeed = winSpeed;
    }

    @Override
    public String toString() {
        return "DayWeatherBean{" +
                "date='" + date + '\'' +
                ", wea='" + wea + '\'' +
                ", weaImg='" + weaImg + '\'' +
                ", temDay='" + temDay + '\'' +
                ", temNight='" + temNight + '\'' +
                ", win='" + win + '\'' +
                ", winSpeed='" + winSpeed + '\'' +
                '}';
    }
}
