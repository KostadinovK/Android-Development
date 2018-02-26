package com.example.kostadin.somenextleveldesign;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_feed;
    ImageButton ibtn_search;
    Button btn_stories;
    Button btn_campaigns;
    Button btn_feed;
    Button btn_scanner;
    Button btn_gifts;
    Button btn_profile;
    ImageButton ibtn_more;
    protected void isntAvailable(){
        Context context = getApplicationContext();
        String text = "This section is not available yet...";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_feed = findViewById(R.id.tv_feed);
        ibtn_search = findViewById(R.id.ibtn_search);
        btn_stories = findViewById(R.id.btn_stories);
        btn_campaigns = findViewById(R.id.btn_campaigns);
        btn_feed = findViewById(R.id.btn_feed);
        btn_scanner = findViewById(R.id.btn_scanner);
        btn_gifts = findViewById(R.id.btn_gifts);
        btn_profile = findViewById(R.id.btn_profile);
        ibtn_more = findViewById(R.id.ibtn_more);

        ibtn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isntAvailable();
            }
        });

        btn_campaigns.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                isntAvailable();
            }
        });

        btn_scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               isntAvailable();

            }
        });

        btn_gifts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isntAvailable();
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isntAvailable();
            }
        });

        ibtn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isntAvailable();
            }
        });
    }
}
