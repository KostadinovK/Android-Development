package com.kosta.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Kostadin Kostadinov on 10/04/2018.
 */

class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private List<Post> data;

    public PostAdapter(List<Post> data){
        this.data = data;

    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        PostViewHolder vh = null;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        vh = new PostViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post item = data.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
