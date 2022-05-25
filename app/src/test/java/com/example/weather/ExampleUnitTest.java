package com.example.weather;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testNetUtil(){
        String s = NetUtil.doGet("https://www.yiketianqi.com/free/week?unescape=1&appid=36728299&appsecret=VUqR1b9W");
        System.out.println(s);
    }
}