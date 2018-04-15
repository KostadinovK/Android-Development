package com.kosta.hotornot.RecycleViewClasses;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kosta.hotornot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherCardViewHolder extends BaseViewHolder<WeatherCard> {

    @BindView(R.id.rl_weathercard)
    RelativeLayout mCard;
    @BindView(R.id.txt_clouds_procents)
    TextView mCloudsPercents;
    @BindView(R.id.txt_date)
    TextView mDate;
    @BindView(R.id.txt_description)
    TextView mDescription;
    @BindView(R.id.txt_humidity_procents)
    TextView mHumidityPercents;
    @BindView(R.id.txt_range)
    TextView mRange;
    @BindView(R.id.txt_temperature)
    TextView mTemperature;
    @BindView(R.id.txt_weather)
    TextView mWeather;
    @BindView(R.id.txt_wind_speed)
    TextView mWindSpeed;
    private WeatherCard item;

    public WeatherCardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(WeatherCard card) {
        this.mCloudsPercents.setText(card.getCloudsProcent());
        this.mDate.setText(card.getDate());
        this.mDescription.setText(card.getDescription());
        this.mHumidityPercents.setText(card.getHumidityProcent());
        this.mRange.setText(card.getRange());
        this.mTemperature.setText(card.getTemperature());
        //TODO changing color via temperature
        this.mWeather.setText(card.getWeather());
        this.mWindSpeed.setText(card.getWindSpeed());
    }
}
