package com.dharani.navigationdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dharani.navigationdemo.activity.ProductItems;
import com.dharani.navigationdemo.asynctask.Department;
import com.dharani.navigationdemo.data.AndroidVersion;
import com.dharani.navigationdemo.activity.ProductListActivity;
import com.dharani.navigationdemo.R;
import com.dharani.navigationdemo.data.MyData;
import com.dharani.navigationdemo.fragment.HomeFragment;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> android;
    private String dataSet;
    private String[] image;
    String productName;
    String id;
    public static String dept;
    private ArrayList<String> al3;
    private ArrayList<String> al2;
//    public HomeAdapter(String  data,String[] image) {
//        this.dataSet = data;
//        this.image = image;
//
//    }
public HomeAdapter()
{

}

    public HomeAdapter(ArrayList<String> al, ArrayList<String> al2) {

        this.al3 = al;
        this.al2 = al2;
        Log.e("Set Text -> ",""+al3);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_adapter, parent, false);
        view.setOnClickListener(HomeFragment.myOnClickListener);
        ViewHolder vHolder = new ViewHolder(view);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        ProductItems current=data.get(position);
//        holder.productImage.setImageResource(current.getProductImage());
//        holder.seller.setText(current.getSellerName());
//        holder.priceSymbol.setText(current.getPriceTag());
//        holder.productName.setText(current.getProductName());

        //MyData curent=al3.get(position);


        holder.id.setText(al3.get(position));
        holder.tvAndroid.setText(al2.get(position));


        // holder.imgAndroid.setImageResource(MyData.productImage[position]);
//        Picasso.with(context)
//                .load(dataSet[position])
//                .resize(140,120)
//                .into(holder.imgAndroid);
    }

    @Override
    public int getItemCount() {
        return al3.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAndroid, id;
        private ImageView imgAndroid;
        Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvAndroid = (TextView) itemView.findViewById(R.id.textView_ID);
            imgAndroid = (ImageView) itemView.findViewById(R.id.imageView_ID);
            id = (TextView) itemView.findViewById(R.id.dept_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Clicked item !!" + getPosition(), Toast.LENGTH_SHORT).show();
                     dept=id.getText().toString();
//Toast.makeText(context,"dept is "+dept,Toast.LENGTH_LONG).show();
//                    if(getPosition()==0)
//                    {
//                        String dept="Electronics";
//                    }
//                    else if(getPosition()==1)
//                    {
//                        String dept="Home Furnitures";
//                    }
//                    else if(getPosition()==2)
//                    {
//                        String dept="Education";
//                    }
//                    else if(getPosition()==3){
//
//                        String dept="Technology";
//                    }
                    Intent intent = new Intent(context, ProductListActivity.class);
                    intent.putExtra("pos", getPosition());
                    context.startActivity(intent);
                }
            });

        }
    }
}
