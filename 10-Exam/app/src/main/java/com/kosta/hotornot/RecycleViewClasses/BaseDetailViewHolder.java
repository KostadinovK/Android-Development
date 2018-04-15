package com.kosta.hotornot.RecycleViewClasses;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseDetailViewHolder<DetailCard> extends RecyclerView.ViewHolder {

    public BaseDetailViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(DetailCard item);
}
