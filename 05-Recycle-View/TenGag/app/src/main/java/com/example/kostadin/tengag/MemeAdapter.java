package com.example.kostadin.tengag;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Kostadin Kostadinov on 02/03/2018.
 */

class MemeAdapter extends RecyclerView.Adapter<MemeViewHolder> {
    private List<Meme> data;

    public MemeAdapter(List<Meme> data){
        this.data = data;

    }
    @Override
    public MemeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meme_layout, parent, false);
        MemeViewHolder vh = new MemeViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MemeViewHolder holder, int position) {
        Meme item = data.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
