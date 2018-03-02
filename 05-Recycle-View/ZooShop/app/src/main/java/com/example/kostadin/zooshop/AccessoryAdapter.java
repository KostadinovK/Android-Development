package com.example.kostadin.zooshop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kostadin Kostadinov on 01/03/2018.
 */

class AccessoryAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    private static final int TYPE_ACCESSORY = 1;
    private static final int TYPE_PROMOTION = 2;
    private List<BaseItem> data;

    public AccessoryAdapter(List<BaseItem> data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        BaseItem item = data.get(position);
        if(item instanceof Accessory)return TYPE_ACCESSORY;
        return TYPE_PROMOTION;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        BaseViewHolder vh = null;
        if(viewType == TYPE_ACCESSORY){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accessory,parent,false);
            vh = new AccessoryViewHolder(view);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promotion,parent,false);
            vh = new PromotionViewHolder(view);
        }
        return vh;

    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        BaseItem item = data.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
