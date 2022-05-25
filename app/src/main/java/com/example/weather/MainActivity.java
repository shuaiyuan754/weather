package com.example.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

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

import com.example.weather.util.NetUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AppCompatSpinner spinner;
    private String[] cities;
    private ArrayAdapter<String> adapter;
    private TextView currentTem;
    private ImageView weatherIcon;
    private TextView date;
    private TextView range;
    private TextView win;
    private TextView air;
    private Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                String weather = (String) msg.obj;
                Log.d(TAG, "handleMessage: " + weather);
            }
        }
    };

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
        currentTem = this.findViewById(R.id.current_tem);
        date = this.findViewById(R.id.tv_date);
        range = this.findViewById(R.id.range_tem);
        win = this.findViewById(R.id.tv_win);
        air = this.findViewById(R.id.tv_air);



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