package com.mobprog.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderPage extends AppCompatActivity {
    Integer qty;
    Button myOrders, orderMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        TextView itemPrice, itemName;

        itemName = findViewById(R.id.OrderItemName);
        itemName.setText(getIntent().getStringExtra("OrderName"));

        itemPrice = findViewById(R.id.OrderItemPrice);
        itemPrice.setText("Rp " + getIntent().getStringExtra("OrderPrice"));

        //for debugging purpose
        Log.d("Order Name", getIntent().getStringExtra("OrderName"));
        Log.d("Order Price", getIntent().getStringExtra("OrderPrice"));

        //order more
        orderMore = findViewById(R.id.OrderMoreBtn);
        orderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OrderMore = new Intent(OrderPage.this, MainActivity.class);
                startActivity(OrderMore);
            }
        });

        //langsung ke myorder
        myOrders = findViewById(R.id.shoppingbag);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(OrderPage.this, MyOrders_Page.class);
                startActivity(orderIntent);
            }
        });
    }
}