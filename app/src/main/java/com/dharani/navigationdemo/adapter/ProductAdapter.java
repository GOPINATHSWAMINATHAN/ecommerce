package com.dharani.navigationdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dharani.navigationdemo.activity.ElectronicsProduct;
import com.dharani.navigationdemo.activity.ProductListActivity;
import com.dharani.navigationdemo.R;

import java.util.ArrayList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

   private static ArrayList a,b,c,d;

    public ProductAdapter(ArrayList a, ArrayList b, ArrayList c, ArrayList d) {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerViewProduct;
        TextView txtProduct;
        Context context;
        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            recyclerViewProduct = (RecyclerView)itemView.findViewById(R.id.recyclerProduct_ID);
            txtProduct = (TextView)itemView.findViewById(R.id.text_productID);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent inte = new Intent(context,ElectronicsProduct.class);
                    context.startActivity(inte);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_card,parent,false);

        view.setOnClickListener(ProductListActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtProduct.setText(a.get(position).toString());
        Log.e("DEPARTMENT VALUE IS",""+a.get(0));
    }


    @Override
    public int getItemCount() {
        return a.size();
    }
}
