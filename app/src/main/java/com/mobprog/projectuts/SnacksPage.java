package com.mobprog.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class SnacksPage extends AppCompatActivity {

    ArrayList<HashMap>snackList = new ArrayList();
    RecyclerView snackRecycler;
    SnackAdapter snackAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_page);
        snackRecycler = findViewById(R.id.snacksRecyclerView);


        //set multiple hashmap untuk nambah makanan
        HashMap<String, String>snack1 = new HashMap<>();
        snack1.put("SnackName", "Risoles Mayones");
        snack1.put("SnackPrice", "7000");

        HashMap<String, String>snack2 = new HashMap<>();
        snack2.put("SnackName", "Lumpia");
        snack2.put("SnackPrice", "8000");

        HashMap<String, String>snack3 = new HashMap<>();
        snack3.put("SnackName", "Bolu Kukus");
        snack3.put("SnackPrice", "5000");

        HashMap<String, String>snack4 = new HashMap<>();
        snack4.put("SnackName", "Donat Kentang");
        snack4.put("SnackPrice", "8000");

        HashMap<String, String>snack5 = new HashMap<>();
        snack5.put("SnackName", "Donat Meses");
        snack5.put("SnackPrice", "3000");

        HashMap<String, String>snack6 = new HashMap<>();
        snack6.put("SnackName", "Lemper Ayam");
        snack6.put("SnackPrice", "7000");

        snackList.add(snack1);
        snackList.add(snack2);
        snackList.add(snack3);
        snackList.add(snack4);
        snackList.add(snack5);
        snackList.add(snack6);


        snackAdapter = new SnackAdapter(getApplicationContext(), snackList);
        snackRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        snackRecycler.setAdapter(snackAdapter);
    }
}