package com.kosta.hotornot.RecycleViewClasses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kosta.hotornot.R;

import java.util.List;

public class WeatherCardAdapter extends RecyclerView.Adapter<WeatherCardViewHolder> {
    private List<WeatherCard> data;

    public WeatherCardAdapter(List<WeatherCard> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public WeatherCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        WeatherCardViewHolder vh = null;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_card_layout, parent, false);
        vh = new WeatherCardViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(WeatherCardViewHolder holder, int position) {
        WeatherCard item = data.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
