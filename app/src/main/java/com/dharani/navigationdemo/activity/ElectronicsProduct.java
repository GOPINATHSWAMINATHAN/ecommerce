package com.dharani.navigationdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ViewFlipper;

import com.dharani.navigationdemo.R;
import com.dharani.navigationdemo.adapter.ProductsShowAdapter;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsProduct extends AppCompatActivity {

    ViewFlipper mflipper;

    private static RecyclerView.Adapter adapter;
    List<ProductItems> items = new ArrayList<>();

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_product);
        ProductItems pi = new ProductItems(R.drawable.image_one, "Furniture", "Pulipandy", "$", 500, 3);
        ProductItems pi1 = new ProductItems(R.drawable.image_one, "Furniture", "Pulipandy", "$", 500, 3);
        ProductItems pi2 = new ProductItems(R.drawable.image_one, "Furniture", "Pulipandy", "$", 500, 3);
        ProductItems pi3 = new ProductItems(R.drawable.image_one, "Furniture", "Pulipandy", "$", 500, 3);
        ProductItems pi4 = new ProductItems(R.drawable.image_one, "Furniture", "Pulipandy", "$", 500, 3);
        items.add(pi);
        items.add(pi1);
        items.add(pi2);
        items.add(pi3);
        items.add(pi4);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.product_populate);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductsShowAdapter(this, items);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
