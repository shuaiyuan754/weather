package com.example.weather.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Administrator
 * @creat time 2022/5/25 9:32
 * description:
 **/
public class NetUtil {

    public static final String WEATHER_URL = "https://www.yiketianqi.com/free/week?unescape=1&appid=36728299&appsecret=VUqR1b9W";

    public static String doGet(String urlStr){
        String data = "";
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            //连接网络
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);

            //从连接中读取二进制流
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);

            //送入缓冲区
            bufferedReader = new BufferedReader(inputStreamReader);

            //从缓冲区读取字串
            StringBuilder stringBuilder = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null ){
                stringBuilder.append(line);
            }
            data = stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                connection.disconnect();
            }

            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return data;
    }

    public static String getWeatherOfCity(String city){
         return doGet(WEATHER_URL + "&city=" + city);

    }
}
