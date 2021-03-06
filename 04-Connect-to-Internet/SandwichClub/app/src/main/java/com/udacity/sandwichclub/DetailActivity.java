package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @BindView(R.id.image_iv) ImageView ingredientsIv;
    @BindView(R.id.txt_name) TextView txt_name;
    @BindView(R.id.also_known_tv) TextView txt_alsoKnownAs;
    @BindView(R.id.ingredients_tv) TextView txt_ingredients;
    @BindView(R.id.origin_tv) TextView txt_origin;
    @BindView(R.id.description_tv) TextView txt_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);


        //setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        txt_name.setText(sandwich.getMainName());
        txt_alsoKnownAs.setText(listToString(sandwich.getAlsoKnownAs()));
        txt_ingredients.setText(listToString(sandwich.getIngredients()));
        txt_origin.setText(sandwich.getPlaceOfOrigin());
        txt_description.setText(sandwich.getDescription());
    }
    private String listToString(List<String> items){
        if (items == null || items.size() == 0) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        String SEPARATOR = ", ";

        for(String item: items) {
            stringBuilder.append(item);
            stringBuilder.append(SEPARATOR);
        }

        // Remove last comma
        String output = stringBuilder.toString();

        if (output.length() > SEPARATOR.length()) {
            try {
                output = output.substring(0, output.length() - SEPARATOR.length());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return output;

    }
}
