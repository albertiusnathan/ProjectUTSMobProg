package com.mobprog.projectuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodsViewHolder> {

    Context context;
    ArrayList<HashMap> foodList = new ArrayList();

    public FoodAdapter(Context context, ArrayList<HashMap> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_item_layout, parent, false);
        return new FoodsViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodsViewHolder holder, int position) {
        HashMap<String, String>foodMap = foodList.get(position);
        holder.foodLayoutBtn.setText(foodMap.get("FoodName") + "\n" + "Rp "+ foodMap.get("FoodPrice"));

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class FoodsViewHolder extends RecyclerView.ViewHolder {
        Button foodLayoutBtn;

        public FoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            foodLayoutBtn = itemView.findViewById(R.id.foodlayoutBtn);
        }
    }
}
