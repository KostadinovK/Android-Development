package com.example.kostadin.tengag;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kostadin Kostadinov on 02/03/2018.
 */

class MemeViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.meme_title) TextView memeTitle;
    @BindView(R.id.meme_img) ImageView memeImg;
    @BindView(R.id.points) TextView points;
    @BindView(R.id.comments) TextView comments;
    @BindView(R.id.btn_like) ImageButton btn_like;
    @BindView(R.id.btn_dislike) ImageButton btn_dislike;
    @BindView(R.id.btn_comment) ImageButton btn_comment;

    private Meme item;

    public MemeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }

    public void setData(Meme item){
        this.memeTitle.setText(item.getTitle());
        this.points.setText(item.getPoints());
        this.comments.setText(item.getComments());
        Picasso.with(itemView.getContext()).load(item.getMemeUrl()).into(memeImg);

    }
}
