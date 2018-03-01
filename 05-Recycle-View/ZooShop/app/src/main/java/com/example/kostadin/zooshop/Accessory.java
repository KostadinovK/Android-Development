package com.example.kostadin.zooshop;

/**
 * Created by Kostadin Kostadinov on 01/03/2018.
 */

public class Accessory {

    private String name;
    private String description;
    private String imageUrl;
    private boolean isLiked;

    public Accessory(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.isLiked = false;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public String getImageUrl(){
        return this.imageUrl;
    }
    public boolean isLiked(){
        return this.isLiked;
    }

    public void setLiked() {
        this.isLiked = true;
    }
}
