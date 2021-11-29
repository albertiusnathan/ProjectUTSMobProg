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

    TextView itemPrice, itemName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

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

                String OrderNameStr = getIntent().getStringExtra("OrderName");
                Integer OrderPriceInt = Integer.parseInt(getIntent().getStringExtra("OrderPrice")) ;
                Integer OrderQtyInt = Integer.parseInt(edittxtQty.getText().toString());

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
                    Log.d("Order Number", String.valueOf(getTotalCount()));
                    Log.d("Order Name", getIntent().getStringExtra("OrderName"));
                    Log.d("Order Price", getIntent().getStringExtra("OrderPrice"));
                    Log.d("Order Qty", edittxtQty.getText().toString());

                    //insert data ke AL
                    orderNames.add(OrderNameStr);
                    orderPrices.add(OrderPriceInt);
                    orderQtys.add(OrderQtyInt);

                    Log.d("Order no", String.valueOf(getTotalCount()));
                    Log.d("Order Name", orderNames.get(getTotalCount()-1));
                    Log.d("Order Price", String.valueOf(orderPrices.get(getTotalCount()-1)));
                    Log.d("Order Qty", String.valueOf(orderQtys.get(getTotalCount()-1)));


//                    OrderMore.putExtra("OrderName", orderNames.get(getTotalCount()));
//                    OrderMore.putExtra("OrderPrice", orderPrices.get(getTotalCount()).toString());
//                    OrderMore.putExtra("OrderQty", orderQtys.get(getTotalCount()).toString());

                    //closing statements
                    String outputMsg = "Order Recorded!";
                    Toast.makeText(getApplicationContext(), outputMsg, Toast.LENGTH_SHORT).show();
                    //orderCount++;

                    ((OrderPage) OrderPage.this).startActivity(OrderMore);


                    //startActivity(OrderMore);
                }


                    }
                });

        myOrders = findViewById(R.id.shoppingbag);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(OrderPage.this, MyOrders_Page.class);

                String OrderNameStr = getIntent().getStringExtra("OrderName");
                Integer OrderPriceInt = Integer.parseInt(getIntent().getStringExtra("OrderPrice")) ;
                Integer OrderQtyInt = Integer.parseInt(edittxtQty.getText().toString());

                orderNames.add(OrderNameStr);
                orderPrices.add(OrderPriceInt);
                orderQtys.add(OrderQtyInt);

                orderIntent.putExtra("OrderNameAL", orderNames);
                orderIntent.putExtra("OrderPriceAL", orderPrices);
                orderIntent.putExtra("OrderNameAL", orderQtys);

                startActivity(orderIntent);
            }
        });


        //langsung ke myorder

    }

    public int getTotalCount(){
        Log.d("ArraySize", String.valueOf(orderNames.size()));
        return orderNames.size();
    }
}