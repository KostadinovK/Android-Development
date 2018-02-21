package com.example.kostadin.coffeeorderapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String userName;
    private boolean hasExtraSugar = false;
    private boolean hasCream = false;

    private int quantity = 0;

    EditText username;
    TextView tv_quantity;
    CheckBox sugar;
    CheckBox cream;
    Button less;
    Button more;
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        less = findViewById(R.id.btn_less);
        username = findViewById(R.id.edt_username);
        cream = findViewById(R.id.cb_cream);
        sugar = findViewById(R.id.cb_sugar);
        tv_quantity = findViewById(R.id.tv_coffeeCount);
        more = findViewById(R.id.btn_more);
        orderBtn = findViewById(R.id.btn_order);

        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quantityStr = tv_quantity.getText().toString();
                quantity = Integer.parseInt(quantityStr);
                if(quantity > 1)quantity--;
                quantityStr = Integer.toString(quantity);
                tv_quantity.setText(quantityStr);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quantityStr = tv_quantity.getText().toString();
                quantity = Integer.parseInt(quantityStr);
                quantity++;
                quantityStr = Integer.toString(quantity);
                tv_quantity.setText(quantityStr);
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = username.getText().toString();
                String order = "Name: " + userName + ".\n" + "Hello, I want to order ";
                String quantityStr = tv_quantity.getText().toString();
                quantity = Integer.parseInt(quantityStr);
                if(quantity == 1)order += "one coffee with ";
                else order += quantity + " coffees with ";
                if(cream.isChecked() && sugar.isChecked())order += "cream topping and extra sugar.\n";
                else if(cream.isChecked())order += "cream topping.\n";
                else if(sugar.isChecked())order += "extra sugar.\n";
                else order += "no cream topping and extra sugar.\n";

                order += "Thank you so much! :)";

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + " "));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order");
                emailIntent.putExtra(Intent.EXTRA_TEXT, order);
                startActivity(emailIntent);



            }
        });
    }
}
