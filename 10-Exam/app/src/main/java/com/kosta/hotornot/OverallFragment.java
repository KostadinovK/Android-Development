package com.kosta.hotornot;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kosta.hotornot.RecycleViewClasses.WeatherCard;
import com.kosta.hotornot.RecycleViewClasses.WeatherCardAdapter;
import com.kosta.hotornot.RecycleViewClasses.WeatherList;

import java.util.ArrayList;
import java.util.List;

public class OverallFragment extends Fragment {
    private static List<WeatherCard> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overall, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        data = WeatherList.getData();
        WeatherCardAdapter weatherCardAdapter = new WeatherCardAdapter(data);
        recyclerView.setAdapter(weatherCardAdapter);
        return view;
    }
}
