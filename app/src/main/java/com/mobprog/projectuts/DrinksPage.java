package com.mobprog.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class DrinksPage extends AppCompatActivity {

    ArrayList<HashMap>drinksList = new ArrayList();
    RecyclerView drinkRecycler;
    DrinksAdapter drinkAdapter;

    Button myOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_page);
        drinkRecycler = findViewById(R.id.drinksRecyclerView);


        //set multiple hashmap untuk nambah makanan
        HashMap<String, String>drink1 = new HashMap<>();
        drink1.put("DrinkName", "Smoothie Ichigo");
        drink1.put("DrinkPrice", "17000");

        HashMap<String, String>drink2 = new HashMap<>();
        drink2.put("DrinkName", "Smoothie Choco");
        drink2.put("DrinkPrice", "15000");

        HashMap<String, String>drink3 = new HashMap<>();
        drink3.put("DrinkName", "Smoothie Banana");
        drink3.put("DrinkPrice", "25000");

        HashMap<String, String>drink4 = new HashMap<>();
        drink4.put("DrinkName", "Froot Splash");
        drink4.put("DrinkPrice", "25000");

        HashMap<String, String>drink5 = new HashMap<>();
        drink5.put("DrinkName", "Aqua Galon");
        drink5.put("DrinkPrice", "20000");

        HashMap<String, String>drink6 = new HashMap<>();
        drink6.put("DrinkName", "Ocean View");
        drink6.put("DrinkPrice", "27000");

        drinksList.add(drink1);
        drinksList.add(drink2);
        drinksList.add(drink3);
        drinksList.add(drink4);
        drinksList.add(drink5);
        drinksList.add(drink6);

        drinkAdapter = new DrinksAdapter(DrinksPage.this, drinksList);
        drinkRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        drinkRecycler.setAdapter(drinkAdapter);

        myOrders = findViewById(R.id.shoppingbag);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(DrinksPage.this, MyOrders_Page.class);
                startActivity(orderIntent);
            }
        });
    }


}