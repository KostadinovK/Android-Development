package com.kosta.homework;

import android.content.Context;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class AppDatabase {
    private static Context context;
    public AppDatabase(Context context){
        this.context = context;
    }
    public static List<Post> database;

    public static List<Post> getData(){
        if(database == null)database = setDatabase();
        return database;
    }

    public static List<Post> setDatabase(){
        //return Arrays.asList(new Post(new ImageView(context).setImageDrawable();,new ));
        return null;

    }
}
