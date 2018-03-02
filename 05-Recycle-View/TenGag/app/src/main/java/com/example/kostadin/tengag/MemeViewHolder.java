package com.example.kostadin.tengag;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @OnClick(R.id.btn_like)
    public void onLikeClick(){
        btn_like.setEnabled(false);
        btn_like.setImageResource(R.mipmap.ic_keyboard_arrow_up_white_36dp);
        btn_dislike.setImageResource(R.mipmap.ic_keyboard_arrow_down_black_36dp);
        btn_dislike.setEnabled(true);
        int num = Integer.parseInt(this.points.getText().toString());
        num++;
        this.points.setText(Integer.toString(num));
    }
    @OnClick(R.id.btn_dislike)
    public void onDislike(){
        btn_like.setEnabled(true);
        btn_like.setImageResource(R.mipmap.ic_keyboard_arrow_up_black_36dp);
        btn_dislike.setImageResource(R.mipmap.ic_keyboard_arrow_down_white_36dp);
        btn_dislike.setEnabled(false);
        int num = Integer.parseInt(this.points.getText().toString());
        num--;
        this.points.setText(Integer.toString(num));
    }
    @OnClick(R.id.btn_comment)
    public void onCommentClicked(){
        int num = Integer.parseInt(this.comments.getText().toString());
        num++;
        this.comments.setText(Integer.toString(num));
        Context context = itemView.getContext();
        Intent intent = new Intent(context,MessageSection.class);
        context.startActivity(intent);

    }
    public void setData(Meme item){
        this.memeTitle.setText(item.getTitle());
        this.points.setText(item.getPoints());
        this.comments.setText(item.getComments());
        Picasso.with(itemView.getContext()).load(item.getMemeUrl()).into(memeImg);

    }
}
