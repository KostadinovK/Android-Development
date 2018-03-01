package com.example.kostadin.zooshop;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kostadin Kostadinov on 01/03/2018.
 */

class AccessoryAdapter extends RecyclerView.Adapter<AccessoryViewHolder>{
    private List<Accessory> data;

    public AccessoryAdapter(List<Accessory> data) {
        this.data = data;
    }

    @Override
    public AccessoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accessory,parent,false);
        AccessoryViewHolder vh = new AccessoryViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(AccessoryViewHolder holder, int position) {
        Accessory item = data.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
