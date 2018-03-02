package com.example.kostadin.tengag;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Kostadin Kostadinov on 03/03/2018.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(T item);
}
