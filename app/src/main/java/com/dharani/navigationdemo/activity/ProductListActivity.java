package com.dharani.navigationdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dharani.navigationdemo.adapter.HomeAdapter;
import com.dharani.navigationdemo.asynctask.Category;
import com.dharani.navigationdemo.data.MyData;
import com.dharani.navigationdemo.R;
import com.dharani.navigationdemo.adapter.ProductAdapter;
import com.dharani.navigationdemo.pojo.CategoryFetchEvent;
import com.dharani.navigationdemo.pojo.FetchCompletedEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<String> data;
    public static View.OnClickListener myOnClickListener;
ArrayList dept,catid,category,id=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
       // EventBus.getDefault().register(this);
        new Category().execute();
        Intent intent = getIntent();
        int position = intent.getExtras().getInt("pos");

        myOnClickListener = new MyOnClickListener(this);
        MyData.pos = position;

        recyclerView = (RecyclerView)findViewById(R.id.recyclerProduct_ID);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//        adapter = new ProductAdapter(MyData.programs[position]);
//        recyclerView.setAdapter(adapter);


    }
    ProductListActivity()
    {

    }

    public ProductListActivity(ArrayList department, ArrayList catid, ArrayList category, ArrayList id)
    {
        this.dept=department;
        this.catid=catid;
        this.category=category;
        this.id=id;
        Toast.makeText(getApplicationContext(),"PRODUCT VALUES ARE"+dept,Toast.LENGTH_LONG).show();
        adapter = new ProductAdapter(dept,catid,category,id);
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
