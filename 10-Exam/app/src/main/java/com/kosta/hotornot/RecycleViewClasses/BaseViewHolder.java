
package com.kosta.hotornot.RecycleViewClasses;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<WeatherCard> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(WeatherCard item);
}
