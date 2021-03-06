package com.kosta.homework;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kostadin Kostadinov on 10/04/2018.
 */

public class PostViewHolder extends BaseViewHolder<Post> {
    @BindView(R.id.img_avatar)
    ImageView mProfilePicture;
    @BindView(R.id.txt_username)
    TextView mUsername;
    @BindView(R.id.txt_date_time)
    TextView mDateTime;
    @BindView(R.id.ibtn_more)
    ImageButton mMoreOptionsMenu;
    @BindView(R.id.img_picture)
    ImageView mPicture;
    @BindView(R.id.txt_description)
    TextView mInfo;
    @BindView(R.id.btn_sock)
    ImageButton mSock;
    @BindView(R.id.txt_likes)
    TextView mLikes;
    @BindView(R.id.btn_share)
    ImageButton mShare;
    @BindView(R.id.txt_send_gift)
    TextView mSendGift;
    private Post item;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(Post post) {
        this.mProfilePicture = post.getProfilePicture();
        this.mUsername.setText(post.getUsername());
        this.mDateTime.setText(post.getDateAndTime());
        this.mMoreOptionsMenu = post.getMoreOptionsImageBtn();
        this.mPicture = post.getPicture();
        this.mInfo.setText(post.getDescription());
        this.mSock = post.getSock();
        this.mLikes.setText(String.valueOf(post.getLikes()));
        this.mShare = post.getShare();
        this.mSendGift.setText(post.getSendGift());
    }
}
