package com.kosta.hotornot;

;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kosta.hotornot.RecycleViewClasses.DetailCard;
import com.kosta.hotornot.RecycleViewClasses.DetailCardAdapter;
import com.kosta.hotornot.RecycleViewClasses.DetailsList;


import java.util.ArrayList;
import java.util.List;

public class DetailsFragment extends Fragment {
    private static List<DetailCard> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        data = DetailsList.getData();
        DetailCardAdapter detailCardAdapter = new DetailCardAdapter(data);
        recyclerView.setAdapter(detailCardAdapter);
        return view;
    }

}
