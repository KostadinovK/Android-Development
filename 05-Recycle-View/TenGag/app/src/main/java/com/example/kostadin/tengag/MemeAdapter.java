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

class MemeAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int TYPE_MEME = 1;
    private static final int TYPE_ADD = 2;

    private List<BaseModel> data;

    public MemeAdapter(List<BaseModel> data){
        this.data = data;

    }
    @Override
    public int getItemViewType(int position) {
        BaseModel item = data.get(position);
        if(item instanceof Meme)return TYPE_MEME;
        return TYPE_ADD;
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        BaseViewHolder vh = null;
        if(viewType == TYPE_MEME){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meme_layout, parent, false);
            vh = new MemeViewHolder(v);
        }else{
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_layout, parent, false);
            vh = new AddViewHolder(v);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        BaseModel item = data.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
