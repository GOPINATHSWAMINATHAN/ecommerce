package com.dharani.navigationdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dharani.navigationdemo.activity.AboutProductActivity;
import com.dharani.navigationdemo.activity.ProductItems;
import com.dharani.navigationdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 06/20/17.
 */

public class ProductsShowAdapter extends RecyclerView.Adapter<ProductsShowAdapter.MyViewHolder> {

    private int productImage;
    private List<ProductItems> data = new ArrayList();
    private String productName;
    private String sellerName;
    private String priceTag;
    private int priceValue;
    private int ratingBar;

    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recycleView;
        ImageView productImage;
        TextView productName, seller, priceSymbol, priceValue;
        RatingBar rating;
        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            productImage = (ImageView) itemView.findViewById(R.id.product_image);
            productName = (TextView) itemView.findViewById(R.id.product_name);
            seller = (TextView) itemView.findViewById(R.id.seller_name);
            priceSymbol = (TextView) itemView.findViewById(R.id.price_tag);
            priceValue = (TextView) itemView.findViewById(R.id.price_value);
            rating = (RatingBar) itemView.findViewById(R.id.rating_bar);
            recycleView = (RecyclerView) itemView.findViewById(R.id.product_populate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, AboutProductActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_show, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ProductItems current=data.get(position);
        holder.productImage.setImageResource(current.getProductImage());
        holder.seller.setText(current.getSellerName());
        holder.priceSymbol.setText(current.getPriceTag());
        holder.productName.setText(current.getProductName());
        holder.priceValue.setText(String.valueOf(current.getPriceValue()));
        holder.rating.setMax(current.getRatingBar());
    }

    public ProductsShowAdapter(Context context,List<ProductItems> items) {
        this.context=context;
        data = items;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
