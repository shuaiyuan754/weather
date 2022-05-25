package com.example.weather.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;
import com.example.weather.bean.DayWeatherBean;

import java.util.List;

/**
 * @author Administrator
 * @creat time 2022/5/25 17:32
 * description:
 **/
public class FutureWeatherAdapter extends RecyclerView.Adapter<FutureWeatherAdapter.WeatherViewHolder> {
    private Context mContext;
    private List<DayWeatherBean> dayWeatherBeanList;
    private static final String TAG = "FutureWeatherAdapter";

    public FutureWeatherAdapter(Context mContext, List<DayWeatherBean> dayWeatherBeanList) {
        this.mContext = mContext;
        this.dayWeatherBeanList = dayWeatherBeanList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.future_weather_item, parent, false);
        return new WeatherViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        DayWeatherBean dayWeatherBean = dayWeatherBeanList.get(position);
        Log.d(TAG, "onBindViewHolder: ///////////" + dayWeatherBean);
        holder.weatherIcon.setImageResource(getIcon(dayWeatherBean.getWeaImg()));
        holder.weather.setText(dayWeatherBean.getWea());
        holder.date.setText(dayWeatherBean.getDate());
        holder.range.setText(dayWeatherBean.getTemNight() + "℃~" +dayWeatherBean.getTemDay() + "℃" );
        holder.win.setText(dayWeatherBean.getWin());
        holder.winSpeed.setText(dayWeatherBean.getWinSpeed());

    }

    @Override
    public int getItemCount() {
        if (dayWeatherBeanList == null){
            return 0;
        }
        return dayWeatherBeanList.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView weather;
        ImageView weatherIcon;
        TextView date;
        TextView range;
        TextView win;
        TextView winSpeed;
        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            weatherIcon = itemView.findViewById(R.id.iv_weather);
            weather = itemView.findViewById(R.id.tv_weather);
            date = itemView.findViewById(R.id.tv_date);
            range = itemView.findViewById(R.id.range_tem);
            win = itemView.findViewById(R.id.tv_win);
            winSpeed = itemView.findViewById(R.id.tv_win_speed);
        }
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
}
