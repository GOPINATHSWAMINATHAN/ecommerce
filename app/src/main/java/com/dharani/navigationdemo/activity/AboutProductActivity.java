package com.dharani.navigationdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dharani.navigationdemo.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutProductActivity extends AppCompatActivity {

    private TextView tvName,tvContent,tvReviewCount;
    private TextView tvPriceSymbol, tvPrice;
    private RatingBar ratingBar;
    private CircleImageView circleImageView;
    private ImageView imgViewOne,imgViewTwo,imgViewThree,imgViewFour;
    private Button btBuy,btAddCart;
    private ImageView imgSimilar;
    private TextView similarProductText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_product);

        tvName = (TextView)findViewById(R.id.seller_na);
        tvContent = (TextView)findViewById(R.id.product_description);
        tvReviewCount =(TextView)findViewById(R.id.reviews_count);
        ratingBar = (RatingBar)findViewById(R.id.rating);
        circleImageView = (CircleImageView)findViewById(R.id.circle_image);
        imgViewOne = (ImageView)findViewById(R.id.imageOne);
        imgViewTwo = (ImageView)findViewById(R.id.imageTwo);
        imgViewThree = (ImageView)findViewById(R.id.imageThree);
        imgViewFour = (ImageView)findViewById(R.id.imageFour);
        btBuy = (Button)findViewById(R.id.button_buynow);
        btAddCart = (Button)findViewById(R.id.button_addcart);
        imgSimilar = (ImageView)findViewById(R.id.similar_products);
        similarProductText = (TextView)findViewById(R.id.similar_productName);


    }
}
