package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppCompatSpinner spinner;
    private String[] stringArray;
    private ArrayAdapter<String> adapter;
    private TextView currentTem;
    private ImageView weatherIcon;
    private TextView date;
    private TextView range;
    private TextView win;
    private TextView air;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }



    private void init(){

        spinner = this.findViewById(R.id.sp_city);
        stringArray = getResources().getStringArray(R.array.cities);
        adapter = new ArrayAdapter<>(this,R.layout.spinner_item,stringArray);
        spinner.setAdapter(adapter);

        weatherIcon = this.findViewById(R.id.iv_weather);
        currentTem = this.findViewById(R.id.current_tem);
        date = this.findViewById(R.id.tv_date);
        range = this.findViewById(R.id.range_tem);
        win = this.findViewById(R.id.tv_win);
        air = this.findViewById(R.id.tv_air);

    }
}