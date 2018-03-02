package com.example.kostadin.zooshop;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Kostadin Kostadinov on 01/03/2018.
 */

public class ZooDatabase {
    private static List<BaseItem> database;

    public static List<BaseItem> getDatabase(){
        if(database == null){
            database = setData();
        }
            return database;
    }

    private static List<BaseItem> setData() {
        return Arrays.asList(
                new Accessory("Toothbrush","Super soft cat toothbrush","https://i2.wp.com/best1x.com/wp-content/uploads/2017/05/Best-Cat-Toothbrush-Toothpaste.jpg?resize=768%2C512&ssl=1"),
                new Accessory("Shampoo","Best feather-fluffing shampoo for penguins","https://secure.i.telegraph.co.uk/multimedia/archive/02583/potd-penguin-showe_2583805k.jpg"),
                new Promotion("https://cdn.pixabay.com/photo/2017/11/28/08/12/dog-2983021_960_720.jpg"),
                new Accessory("Toothbrush","Super soft cat toothbrush","https://i2.wp.com/best1x.com/wp-content/uploads/2017/05/Best-Cat-Toothbrush-Toothpaste.jpg?resize=768%2C512&ssl=1"),
                new Accessory("Shampoo","Best feather-fluffing shampoo for penguins","https://secure.i.telegraph.co.uk/multimedia/archive/02583/potd-penguin-showe_2583805k.jpg"));
    }
}
