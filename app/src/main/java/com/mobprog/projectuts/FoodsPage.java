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

public class FoodsPage extends AppCompatActivity {

    ArrayList<HashMap>foodList = new ArrayList();
    RecyclerView foodRecycler;
    FoodAdapter foodAdapter;
    Button myOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foods);
        foodRecycler = findViewById(R.id.foodRecyclerView);

        //set multiple hashmap untuk nambah makanan
        HashMap<String, String>food1 = new HashMap<>();
        food1.put("FoodName", "Nasi Goreng");
        food1.put("FoodPrice", "10000");

        HashMap<String, String>food2 = new HashMap<>();
        food2.put("FoodName", "Ikan Goreng");
        food2.put("FoodPrice", "20000");

        HashMap<String, String>food3 = new HashMap<>();
        food3.put("FoodName", "Ikan Bakar");
        food3.put("FoodPrice", "25000");

        HashMap<String, String>food4 = new HashMap<>();
        food4.put("FoodName", "Sego Kuning");
        food4.put("FoodPrice", "15000");

        HashMap<String, String>food5 = new HashMap<>();
        food5.put("FoodName", "Seblaque");
        food5.put("FoodPrice", "18000");

        HashMap<String, String>food6 = new HashMap<>();
        food6.put("FoodName", "Soto Ayam");
        food6.put("FoodPrice", "15000");

        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);
        foodList.add(food6);


        foodAdapter = new FoodAdapter(FoodsPage.this, foodList);
        foodRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        foodRecycler.setAdapter(foodAdapter);

        myOrders = findViewById(R.id.shoppingbag);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(FoodsPage.this, MyOrders_Page.class);
                startActivity(orderIntent);
            }
        });
    }
}