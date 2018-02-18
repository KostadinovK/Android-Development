package com.example.android.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Kostadin Kostadinov on 17/02/2018.
 */

public class ChildActivity extends AppCompatActivity {
    private TextView mDisplayText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_layout);
        mDisplayText = (TextView)findViewById(R.id.tv_display);
    }
}
