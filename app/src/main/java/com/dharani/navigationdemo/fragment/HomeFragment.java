package com.dharani.navigationdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.dharani.navigationdemo.adapter.HomeAdapter;
import com.dharani.navigationdemo.asynctask.Department;
import com.dharani.navigationdemo.data.MyData;
import com.dharani.navigationdemo.R;
import com.dharani.navigationdemo.pojo.FetchCompletedEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import java.util.ArrayList;

public class HomeFragment extends Fragment {
    View view;
    ViewFlipper viewFlipper;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    public static View.OnClickListener myOnClickListener;
    RecyclerView.Adapter adapter;
//    int flipperImages[] = {R.drawable.ecommerce,R.drawable.electronics,R.drawable.furniture};
ArrayList al;
    ArrayList al2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        viewFlipper = (ViewFlipper)view.findViewById(R.id.viewFlipper_ID);
        collapsingToolbarLayout = (CollapsingToolbarLayout)view.findViewById(R.id.collapsingToolbar);
        for (int i = 0; i < MyData.flipperImages.length; i++){
            setFlipperImage(MyData.flipperImages[i]);
        }
//        new Department().execute();
        EventBus.getDefault().register(this);



        initViews();
        return view;
    }
@Subscribe
    public void onEvent(FetchCompletedEvent event)
    {
        al=event.dept;
        al2=event.id;
        adapter = new HomeAdapter(al,al2);
        recyclerView.setAdapter(adapter);
        Log.d("EVENT CLASS VALUES",""+al+""+al2);
    }

    // Inflate recyclerview and adapter for Homeadapter
    private void initViews() {

        myOnClickListener = new MyOnClickListener(getContext());
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView_ID);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
//        adapter = new HomeAdapter(al,al2);
//        recyclerView.setAdapter(adapter);

        Log.e("adapter value : ",""+this.al +this.al2);
    }
    // Image Flipper part
    private void setFlipperImage(int image) {
        ImageView img = new ImageView(getActivity());
        img.setBackgroundResource(image);
        viewFlipper.addView(img);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        new Department().execute();
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Ecommerce App");
    }

    private static class MyOnClickListener implements View.OnClickListener {
        private Context context;
        public MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {

        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
