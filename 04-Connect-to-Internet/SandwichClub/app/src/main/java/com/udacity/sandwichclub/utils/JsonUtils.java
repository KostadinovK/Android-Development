package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String KEY = "name";
    private static final String SANDWICH_NAME_KEY = "mainName";
    private static final String SANDWICH_KNOWNAS_KEY = "alsoKnownAs";
    private static final String SANDWICH_PLACE_KEY = "placeOfOrigin";
    private static final String SANDWICH_DESCRIPTION_KEY = "description";
    private static final String SANDWICH_IMAGE_KEY = "image";
    private static final String SANDWICH_INGREDIENTS_KEY = "ingredients";
    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObj = new JSONObject(json);
            Sandwich sandwich = new Sandwich();
            if(jsonObj.has(KEY)){
                JSONObject name = jsonObj.getJSONObject(KEY);

                sandwich.setMainName(name.optString(SANDWICH_NAME_KEY));
                List<String> alsoKnownAs = parseJSONArray(name.getJSONArray(SANDWICH_KNOWNAS_KEY));
                sandwich.setAlsoKnownAs(alsoKnownAs);

            }
            if(jsonObj.has(SANDWICH_PLACE_KEY)){
                sandwich.setPlaceOfOrigin(jsonObj.optString(SANDWICH_PLACE_KEY));
            }
            if(jsonObj.has(SANDWICH_DESCRIPTION_KEY)){
                sandwich.setDescription(jsonObj.optString(SANDWICH_DESCRIPTION_KEY));
            }
            if(jsonObj.has(SANDWICH_IMAGE_KEY)){
                sandwich.setImage(jsonObj.optString(SANDWICH_IMAGE_KEY));
            }
            if(jsonObj.has(SANDWICH_INGREDIENTS_KEY)){
                List<String> ingredients = parseJSONArray(jsonObj.getJSONArray(SANDWICH_INGREDIENTS_KEY));
                sandwich.setIngredients(ingredients);
            }
            return sandwich;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }

    }
    private static List<String> parseJSONArray(JSONArray array){
        List<String> items = new ArrayList<String>();
        for(int i = 0;i < array.length();i++){
            items.add(array.optString(i));
        }
        return items;
    }
}
