package com.mobprog.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MyOrders_Page extends AppCompatActivity {

    RecyclerView myOrderRecycler;
    MyOrders_Adapter myOrdersAdapter;

    ArrayList<String> orderNames = new ArrayList<>();
    ArrayList<Integer> orderPrices = new ArrayList<>();
    ArrayList<Integer> orderQtys = new ArrayList<>();

    Integer orderCount;

    Button orderDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders_page);
        myOrderRecycler = findViewById(R.id.myOrderRecyclerView);

        orderNames = (ArrayList<String>) getIntent().getSerializableExtra("OrderNameAL");
        orderPrices = (ArrayList<Integer>) getIntent().getSerializableExtra("OrderPriceAL");
        orderQtys = (ArrayList<Integer>) getIntent().getSerializableExtra("OrderQtyAL");

        Log.d("OrderName", String.valueOf(orderNames));
        Log.d("OrderPrices", String.valueOf(orderPrices));
        Log.d("OrderQty", String.valueOf(orderQtys));

//        orderPrices.add(Integer.parseInt(getIntent().getStringExtra("OrderPrice")));
//        orderQtys.add(Integer.parseInt(getIntent().getStringExtra("OrderQty")));

        myOrdersAdapter = new MyOrders_Adapter(MyOrders_Page.this, orderNames, orderPrices, orderQtys, orderCount);
        myOrderRecycler.setLayoutManager(new LinearLayoutManager(this));
        myOrderRecycler.setAdapter(myOrdersAdapter);


//        //go to home button
//        orderDone = findViewById(R.id.goHomeBtn);
//        orderDone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent orderDoneIntent = new Intent(MyOrders_Page.this, MainActivity.class);
//                startActivity(orderDoneIntent);
//            }
//        });
    }
}