package com.example.kostadin.tengag;

/**
 * Created by Kostadin Kostadinov on 02/03/2018.
 */

public class Meme {
    private String title;
    private String memeUrl;
    private String points;
    private String comments;
    private boolean isLiked;
    private boolean isDisliked;
    private boolean isCommented;

    public Meme(String title, String memeUrl, String points, String comments) {
        this.title = title;
        this.memeUrl = memeUrl;
        this.points = points;
        this.comments = comments;
        this.isDisliked = false;
        this.isLiked = false;
        this.isCommented = false;
    }

    public String getTitle() {
        return title;
    }

    public String getMemeUrl() {
        return memeUrl;
    }

    public String getPoints() {
        return points;
    }

    public String getComments() {
        return comments;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public boolean isDisliked() {
        return isDisliked;
    }

    public boolean isCommented() {
        return isCommented;
    }
}
