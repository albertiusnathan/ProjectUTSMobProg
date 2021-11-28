package com.mobprog.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MyOrders_Page extends AppCompatActivity {

    RecyclerView myOrderRecycler;
    MyOrders_Adapter myOrdersAdapter;

    ArrayList<String> orderNames = new ArrayList<>();
    ArrayList<Integer> orderPrices = new ArrayList<>();
    ArrayList<Integer> orderQtys = new ArrayList<>();

    Integer orderCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders_page);
        myOrderRecycler = findViewById(R.id.myOrderRecyclerView);

        orderNames.add(getIntent().getStringExtra("OrderName"));
        orderPrices.add(Integer.parseInt(getIntent().getStringExtra("OrderPrice")));
        orderQtys.add(Integer.parseInt(getIntent().getStringExtra("OrderQty")));

        myOrdersAdapter = new MyOrders_Adapter(MyOrders_Page.this, orderNames, orderPrices, orderQtys, orderCount);
        myOrderRecycler.setLayoutManager(new LinearLayoutManager(this));
        myOrderRecycler.setAdapter(myOrdersAdapter);
    }
}