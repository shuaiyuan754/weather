package com.example.weather;

import org.junit.Test;

import com.example.weather.util.NetUtil;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testNetUtil(){
        System.out.println(NetUtil.getWeatherOfCity("北京"));
    }
}