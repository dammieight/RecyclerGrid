package com.example.recyclergrid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rView;
    List<String> titles;
    List<Integer> images;
    RViewAdapter rViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("RecyclerList");

        //Initialize recyclerView
        rView = findViewById(R.id.rView);

        //Initialize List
        titles = new ArrayList<>();
        images = new ArrayList<>();

        for (int i = 0; i< 20; i++){
            titles.add("This is the first item");
            titles.add("This is the second item");
            titles.add("This is the third item");
        }

        for (int i = 0; i< 20; i++){
            images.add(R.drawable.ic_people);
            images.add(R.drawable.ic_star);
            images.add(R.drawable.ic_swimmer);
        }

        rViewAdapter = new RViewAdapter(this, titles, images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rView.setLayoutManager(gridLayoutManager);
        rView.setAdapter(rViewAdapter);

    }
}
