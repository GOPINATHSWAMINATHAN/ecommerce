package com.dharani.navigationdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dharani.navigationdemo.data.MyData;
import com.dharani.navigationdemo.R;
import com.dharani.navigationdemo.adapter.ProductAdapter;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<String> data;
    public static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("pos");

        myOnClickListener = new MyOnClickListener(this);
        MyData.pos = position;

        recyclerView = (RecyclerView)findViewById(R.id.recyclerProduct_ID);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ProductAdapter(MyData.programs[position]);
        recyclerView.setAdapter(adapter);

    }

    private static class MyOnClickListener implements View.OnClickListener {
        public MyOnClickListener(ProductListActivity productListActivity) {
        }

        @Override
        public void onClick(View v) {

        }
    }
}
