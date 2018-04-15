package com.kosta.hotornot.RecycleViewClasses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kosta.hotornot.R;

import java.util.List;

public class DetailCardAdapter extends RecyclerView.Adapter<DetailCardViewHolder> {
    private List<DetailCard> data;

    public DetailCardAdapter(List<DetailCard> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public DetailCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        DetailCardViewHolder vh = null;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_card_layout, parent, false);
        vh = new DetailCardViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(DetailCardViewHolder holder, int position) {
        DetailCard item = data.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
