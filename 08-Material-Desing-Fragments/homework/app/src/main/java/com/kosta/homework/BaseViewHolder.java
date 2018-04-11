package com.kosta.homework;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<Post> extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(Post item);
}
