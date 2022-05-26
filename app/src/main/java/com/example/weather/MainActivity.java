package com.example.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.adapter.FutureWeatherAdapter;
import com.example.weather.bean.DayWeatherBean;
import com.example.weather.bean.WeatherBean;
import com.example.weather.util.NetUtil;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AppCompatSpinner spinner;
    private String[] cities;
    private ArrayAdapter<String> adapter;
    private TextView weather;
    private ImageView weatherIcon;
    private TextView date;
    private TextView range;
    private TextView win;
    private TextView winSpeed;
    private Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                String weather = (String) msg.obj;
                Log.d(TAG, "handleMessage: " + weather);

                Gson gson = new Gson();
                WeatherBean weatherBean = gson.fromJson(weather, WeatherBean.class);
                Log.d(TAG, "handleMessage: Bean//////////" + weatherBean);

                updateDayWeather(weatherBean);
                Toast.makeText(MainActivity.this, "更新成功!" + weatherBean.getUpdateTime(), Toast.LENGTH_SHORT).show();

            }
        }
    };
    private RecyclerView recyclerView;
    private List<DayWeatherBean> dayWeatherBeanList;

    @SuppressLint("SetTextI18n")
    private void updateDayWeather(WeatherBean weatherBean) {
        dayWeatherBeanList = weatherBean.getDayWeatherBeanList();
        DayWeatherBean todayWeather = dayWeatherBeanList.get(0);
        weatherIcon.setImageResource(getIcon(todayWeather.getWeaImg()));
        weather.setText(todayWeather.getWea());
        date.setText(todayWeather.getDate());
        range.setText(todayWeather.getTemNight() + "℃~" +todayWeather.getTemDay() + "℃" );
        win.setText(todayWeather.getWin());
        winSpeed.setText(todayWeather.getWinSpeed());

        dayWeatherBeanList.remove(0);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(new FutureWeatherAdapter(this,dayWeatherBeanList));


    }

    private int getIcon(String weaImg) {
        int result = 0;
        switch (weaImg){
            case "xue":
                result = R.drawable.xue_icon;
                break;
            case "lei":
                result = R.drawable.lei_icon;
                break;
            case "shachen":
                result = R.drawable.shachen_icon;
                break;
            case "wu":
                result = R.drawable.wu_icon;
                break;
            case "bingbao":
                result = R.drawable.bingbao_icon;
                break;
            case "yun":
                result = R.drawable.yun_icon;
                break;
            case "yu":
                result = R.drawable.yu_icon;
                break;
            case "yin":
                result = R.drawable.yin_icon;
                break;
            case "qing":
                result = R.drawable.qing_icon;
                break;
            default:
                result = R.drawable.qing_icon;
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }



    private void init(){

        spinner = this.findViewById(R.id.sp_city);
        cities = getResources().getStringArray(R.array.cities);
        adapter = new ArrayAdapter<>(this,R.layout.spinner_item,cities);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String city = cities[i];
                Log.d(TAG, "onItemSelected: " + city);
                getWeatherOfCityInThread(city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        weatherIcon = this.findViewById(R.id.iv_weather);
        weather = this.findViewById(R.id.tv_weather);
        date = this.findViewById(R.id.tv_date);
        range = this.findViewById(R.id.range_tem);
        win = this.findViewById(R.id.tv_win);
        winSpeed = this.findViewById(R.id.tv_win_speed);
        recyclerView = this.findViewById(R.id.future_weather);




    }

    private void getWeatherOfCityInThread(String city) {
        new Thread(){
            @Override
            public void run() {
                String weatherOfCity = NetUtil.getWeatherOfCity(city);
                Log.d(TAG, "run: " + weatherOfCity);
                Message msg = Message.obtain();
                msg.what = 0;
                msg.obj = weatherOfCity;
                handler.sendMessage(msg);

            }
        }.start();
    }


}