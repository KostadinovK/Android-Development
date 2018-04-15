package com.kosta.hotornot.RecycleViewClasses;

import android.view.View;
import android.widget.TextView;

import com.kosta.hotornot.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailCardViewHolder extends BaseDetailViewHolder<DetailCard> {
    @BindView(R.id.txt_detail_date)
    TextView mDetailDate;
    @BindView(R.id.txt_detail_weather)
    TextView mDetailWeather;
    @BindView(R.id.txt_details_description)
    TextView mDetailDescription;

    @BindView(R.id.txt_detail_temperature)
    TextView mDetailTemperature;

    private DetailCard card;

    public DetailCardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(DetailCard item) {
        this.mDetailDate.setText(item.getDate());
        this.mDetailDescription.setText(item.getDescription());
        this.mDetailWeather.setText(item.getWeather());
        this.mDetailTemperature.setText(item.getTemperature());

    }
}
