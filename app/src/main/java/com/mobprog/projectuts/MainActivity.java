package com.mobprog.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button foodBtn, snackBtn, drinksBtn, myOrders;

    //need rework
//    private void hideNavigationBar(){
//        this.getWindow().getDecorView()
//                .setSystemUiVisibility(
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                                | View.SYSTEM_UI_FLAG_IMMERSIVE
//                );
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hideNavigationBar();


        //utk ke food page (copy paste ke page lain)
        foodBtn = findViewById(R.id.foodBtn);
        foodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent foodIntent = new Intent(MainActivity.this, FoodsPage.class);
                startActivity(foodIntent);
            }
        });


        //akses ke drinks
        drinksBtn = findViewById(R.id.drinkBtn);
        drinksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drinksIntent = new Intent(MainActivity.this, DrinksPage.class);
                startActivity(drinksIntent);
            }
        });

        //ke snacks
        snackBtn = findViewById(R.id.snackBtn);
        snackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent snackIntent = new Intent(MainActivity.this, SnacksPage.class);
                startActivity(snackIntent);
            }
        });

        //myorders
        myOrders = findViewById(R.id.shoppingbag);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(MainActivity.this, MyOrders_Page.class);
                startActivity(orderIntent);
            }
        });

    }
}