package com.example.kostadin.tengag;

/**
 * Created by Kostadin Kostadinov on 03/03/2018.
 */

public class Add extends BaseModel{

    private String imageUrl;

    public Add(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {

        return imageUrl;
    }


}
