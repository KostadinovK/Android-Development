package com.example.kostadin.zooshop;

/**
 * Created by Kostadin Kostadinov on 02/03/2018.
 */

public class Promotion extends BaseItem {

    private String imgUrl;

    public Promotion(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
