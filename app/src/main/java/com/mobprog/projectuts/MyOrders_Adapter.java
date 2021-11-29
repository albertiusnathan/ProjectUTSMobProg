package com.mobprog.projectuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrders_Adapter extends RecyclerView.Adapter<MyOrders_Adapter.MyOrdersViewHolder> {
    Context context;
    ArrayList<String> orderNames;
    ArrayList<Integer> orderPrices;
    ArrayList<Integer> orderQtys;
    Integer orderCount;

    public MyOrders_Adapter(Context context, ArrayList<String> orderNames, ArrayList<Integer> orderPrices, ArrayList<Integer> orderQtys, Integer orderCount) {
        this.context = context;
        this.orderNames = orderNames;
        this.orderPrices = orderPrices;
        this.orderQtys = orderQtys;
        this.orderCount = orderCount;
    }

    @NonNull
    @Override
    public MyOrders_Adapter.MyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myorder_layout, parent, false);
        return new MyOrders_Adapter.MyOrdersViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyOrders_Adapter.MyOrdersViewHolder holder, int position) {
//        String orderNumber = orderNames.get(orderCount);
//        holder.myOrderViewLayout.setText(orderNames.get(orderCount) + "\n" + "Rp "+ orderPrices.get(orderCount));

        holder.getItemName().setText(orderNames.get(position));
        holder.getItemPrice().setText(orderPrices.get(position));
        holder.getItemQty().setText(orderQtys.get(position));

//        holder.myOrderViewLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myOrderIntent = new Intent(context, OrderPage.class);
//
//                myOrderIntent.putExtra("OrderName", snackMap.get("SnackName"));
//                myOrderIntent.putExtra("OrderPrice", snackMap.get("SnackPrice"));
//
//                ((SnacksPage) context).startActivity(myOrderIntent);;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return orderNames.size();
    }

    public class MyOrdersViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView itemPrice;
        TextView itemQty;


        public MyOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
            itemPrice = (TextView) itemView.findViewById(R.id.itemPrice);
            itemQty = (TextView) itemView.findViewById(R.id.itemQty);
        }
        public TextView getItemName(){
            return itemName;
        }

        public TextView getItemPrice(){
            return itemPrice;
        }

        public TextView getItemQty(){
            return itemQty;
        }
    }
}
