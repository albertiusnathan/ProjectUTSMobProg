package com.mobprog.projectuts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder> {

    Context context;
    ArrayList<HashMap> drinkList = new ArrayList();

    public DrinksAdapter(Context context, ArrayList<HashMap> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public DrinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drink_item_layout, parent, false);
        return new DrinksViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull DrinksAdapter.DrinksViewHolder holder, int position) {
        HashMap<String, String>drinkMap = drinkList.get(position);
        holder.drinksBtnLayout.setText(drinkMap.get("DrinkName") + "\n" + "Rp "+ drinkMap.get("DrinkPrice"));

        holder.drinksBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drink_orderIntent = new Intent(context, OrderPage.class);

                drink_orderIntent.putExtra("OrderName", drinkMap.get("DrinkName"));
                drink_orderIntent.putExtra("OrderPrice", drinkMap.get("DrinkPrice"));

                ((DrinksPage) context).startActivity(drink_orderIntent);;
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public class DrinksViewHolder extends RecyclerView.ViewHolder {
        Button drinksBtnLayout;

        public DrinksViewHolder(@NonNull View itemView) {
            super(itemView);
            drinksBtnLayout = itemView.findViewById(R.id.drinkBtnLayout);
        }
    }
}
