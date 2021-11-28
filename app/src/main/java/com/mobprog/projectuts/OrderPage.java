package com.mobprog.projectuts;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OrderPage extends AppCompatActivity {

    Button myOrders, orderMore;
    EditText edittxtQty;

    ArrayList<String> orderNames = new ArrayList<>();
    ArrayList<Integer> orderPrices = new ArrayList<>();
    ArrayList<Integer> orderQtys = new ArrayList<>();

    int orderCount = getTotalCount();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        TextView itemPrice, itemName;

        itemName = findViewById(R.id.OrderItemName);
        itemName.setText(getIntent().getStringExtra("OrderName"));

        itemPrice = findViewById(R.id.OrderItemPrice);
        itemPrice.setText("Rp " + getIntent().getStringExtra("OrderPrice"));

        edittxtQty = (EditText) findViewById(R.id.orderQty);


        //order more
        orderMore = findViewById(R.id.OrderMoreBtn);
        orderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OrderMore = new Intent(OrderPage.this, MainActivity.class);


                if(Integer.parseInt(edittxtQty.getText().toString()) == 0 || edittxtQty == null){

                   // for debugging purpose
                    Log.d("Order Name", getIntent().getStringExtra("OrderName"));
                    Log.d("Order Price", getIntent().getStringExtra("OrderPrice"));
                    Log.d("Order Qty", edittxtQty.getText().toString());

                    String warningTxt = "The Quantity can't be zero or blank!";
                    Toast.makeText(getApplicationContext(), warningTxt, Toast.LENGTH_SHORT).show();
                }
                else {
                    //for debugging purpose
                    Log.d("Order Name", getIntent().getStringExtra("OrderName"));
                    Log.d("Order Price", getIntent().getStringExtra("OrderPrice"));
                    Log.d("Order Qty", edittxtQty.getText().toString());

                    //insert data ke AL
                    orderNames.add(getIntent().getStringExtra("OrderName"));
                    orderPrices.add(Integer.parseInt(getIntent().getStringExtra("OrderPrice")));
                    orderQtys.add(Integer.parseInt(edittxtQty.getText().toString()));

                    Log.d("Order no", String.valueOf(orderCount));
                    Log.d("Order Name", orderNames.get(orderCount));
                    Log.d("Order Price", String.valueOf(orderPrices.get(orderCount)));
                    Log.d("Order Qty", String.valueOf(orderQtys.get(orderCount)));


                    OrderMore.putExtra("OrderName", orderNames.get(orderCount));
                    OrderMore.putExtra("OrderPrice", orderPrices.get(orderCount).toString());
                    OrderMore.putExtra("OrderQty", orderQtys.get(orderCount).toString());

                    //closing statements
                    String outputMsg = "Order Recorded!";
                    Toast.makeText(getApplicationContext(), outputMsg, Toast.LENGTH_SHORT).show();
                    //orderCount++;

                    ((OrderPage) OrderPage.this).startActivity(OrderMore);


                    //startActivity(OrderMore);
                }
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

    public int getTotalCount(){
        Log.d("ArraySize", String.valueOf(orderNames.size()));
        return orderNames.size();
    }
}