package com.example.kostadin.coffeeorderapp;

import android.app.Activity;
import android.content.Context;
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
    //prices
    final private int pricePerCoffee = 2;
    final private double milkPrice = 0.5;
    final private double bisquitPrice = 1;
    final private double sugarPrice = 0.1;
    final private double creamPrice = 0.2;

    private String userName;
    private boolean hasExtraSugar = false;
    private boolean hasCream = false;
    private boolean hasMilk = false;
    private boolean withBisquit = false;

    private double price = 0;
    private int quantity = 0;

    EditText username;
    TextView tv_quantity;
    CheckBox sugar;
    CheckBox cream;
    CheckBox milk;
    CheckBox bisquit;
    Button less;
    Button more;
    Button btn_check;
    TextView totalPrice;
    Button orderBtn;
    TextView tv_confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        less = findViewById(R.id.btn_less);
        username = findViewById(R.id.edt_username);
        cream = findViewById(R.id.cb_cream);
        sugar = findViewById(R.id.cb_sugar);
        milk = findViewById(R.id.cb_milk);
        bisquit = findViewById(R.id.cb_bisquit);
        tv_quantity = findViewById(R.id.tv_coffeeCount);
        totalPrice = findViewById(R.id.tv_totalPrice);
        btn_check = findViewById(R.id.btn_checkPrice);
        more = findViewById(R.id.btn_more);
        orderBtn = findViewById(R.id.btn_order);
        tv_confirm = findViewById(R.id.tv_confirm);

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

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String quantityStr = tv_quantity.getText().toString();
                quantity = Integer.parseInt(quantityStr);
                price = pricePerCoffee;
                if(milk.isChecked() || cream.isChecked() || sugar.isChecked() || bisquit.isChecked()){
                    if(quantity != 1){
                        price += pricePerCoffee * (quantity-1);
                    }
                    if(milk.isChecked()){
                        price += milkPrice;
                    }
                    if(cream.isChecked()){
                        price += creamPrice;
                    }
                    if(sugar.isChecked()){
                        price += sugarPrice;
                    }
                    if(bisquit.isChecked()){
                        price += bisquitPrice;
                    }
                }else{
                    if(quantity != 1){
                        price += (quantity-1) * pricePerCoffee;
                    }
                }
                totalPrice.setText("Total Price: " + String.format( "%.2f", price ) + "$");
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = username.getText().toString();
                String order = "Name: " + userName + ".\n" + "Hello, I want to order ";
                String quantityStr = tv_quantity.getText().toString();
                quantity = Integer.parseInt(quantityStr);
                price = 0;
                if(milk.isChecked() || cream.isChecked() || sugar.isChecked() || bisquit.isChecked()){
                    if(quantity == 1){
                        order += "one coffee with:\n ";
                        price += pricePerCoffee;
                    }else{
                        order += quantity + " coffees with:\n";
                        price += pricePerCoffee * quantity;
                    }
                    if(milk.isChecked()){
                        order += "milk\n";
                        price += milkPrice;
                    }
                    if(cream.isChecked()){
                        order += " cream\n";
                        price += creamPrice;
                    }
                    if(sugar.isChecked()){
                        order += " extra sugar\n";
                        price += sugarPrice;
                    }
                    if(bisquit.isChecked()){
                        order += " biscuit\n";
                        price += bisquitPrice;
                    }
                }else{
                    if(quantity == 1){
                        order += "one coffee.\n";
                        price += pricePerCoffee;
                    }else{
                        order += quantity + " coffees.\n";
                        price += quantity * pricePerCoffee;
                    }

                }

                order += "\n\nThank you so much! :)";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + " "));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order");
                emailIntent.putExtra(Intent.EXTRA_TEXT, order);
                startActivity(emailIntent);

                tv_confirm.setText("Your order is confirmed!\nTotal Price: " + String.format("%.2f",price) + " $");
            }
        });
    }
}
