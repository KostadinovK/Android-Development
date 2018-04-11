package com.kosta.homework;

import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Kostadin Kostadinov on 10/04/2018.
 */

public class Post {
    private ImageView profilePicture;
    private String username;
    private String dateAndTime;
    private ImageButton moreOptionsImageBtn;
    private ImageView picture;
    private String description;
    private ImageButton sock;
    private int likes;
    private ImageButton share;
    private String sendGift;

    public Post() {
    }

    public Post(ImageView profilePicture, String username, String dateAndTime,
                ImageButton moreOptionsImageBtn, ImageView picture, String description,
                ImageButton sock, int likes, ImageButton share, String sendGift) {
        this.profilePicture = profilePicture;
        this.username = username;
        this.dateAndTime = dateAndTime;
        this.moreOptionsImageBtn = moreOptionsImageBtn;
        this.picture = picture;
        this.description = description;
        this.sock = sock;
        this.likes = likes;
        this.share = share;
        this.sendGift = sendGift;
    }


    public ImageView getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ImageView profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public ImageButton getMoreOptionsImageBtn() {
        return moreOptionsImageBtn;
    }

    public void setMoreOptionsImageBtn(ImageButton moreOptionsImageBtn) {
        this.moreOptionsImageBtn = moreOptionsImageBtn;
    }

    public ImageView getPicture() {
        return picture;
    }

    public void setPicture(ImageView picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageButton getSock() {
        return sock;
    }

    public void setSock(ImageButton sock) {
        this.sock = sock;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ImageButton getShare() {
        return share;
    }

    public void setShare(ImageButton share) {
        this.share = share;
    }

    public String getSendGift() {
        return sendGift;
    }

    public void setSendGift(String sendGift) {
        this.sendGift = sendGift;
    }
}
