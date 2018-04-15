package com.kosta.hotornot.RecycleViewClasses;

import java.util.Arrays;
import java.util.List;

public class DetailsList {

    public static List<DetailCard> database;

    public static List<DetailCard> getData() {
        if (database == null) database = setDatabase();
        return database;
    }

    public static List<DetailCard> setDatabase() {
        return Arrays.asList(
                new DetailCard("09/02 12:00", "Clouds", "string clouds", "12C")
        );

    }
}
