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

public class SnackAdapter extends RecyclerView.Adapter<SnackAdapter.SnacksViewHolder> {

    Context context;
    ArrayList<HashMap> snackList = new ArrayList();

    public SnackAdapter(Context context, ArrayList<HashMap> snackList) {
        this.context = context;
        this.snackList = snackList;
    }

    @NonNull
    @Override
    public SnacksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.snacks_item_layout, parent, false);
        return new SnacksViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull SnackAdapter.SnacksViewHolder holder, int position) {
        HashMap<String, String>snackMap = snackList.get(position);
        holder.snacksBtnLayout.setText(snackMap.get("DrinkName") + "\n" + "Rp "+ snackMap.get("DrinkPrice"));

    }

    @Override
    public int getItemCount() {
        return snackList.size();
    }

    public class SnacksViewHolder extends RecyclerView.ViewHolder {
        Button snacksBtnLayout;

        public SnacksViewHolder(@NonNull View itemView) {
            super(itemView);
            snacksBtnLayout = itemView.findViewById(R.id.snacksLayoutBtn);
        }
    }
}
