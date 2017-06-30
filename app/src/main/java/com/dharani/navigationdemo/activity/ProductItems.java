package com.dharani.navigationdemo.activity;

/**
 * Created by LENOVO on 06/20/17.
 */

public class ProductItems {
    private static int productImage;
    private static String productName;
    private static String sellerName;
    private static  String priceTag;
    private static int priceValue;
    private static int ratingBar;

    ProductItems(int pi,String pn,String sn,String pt,int pv,int rb)
    {
        productImage=pi;
        productName=pn;
        sellerName=sn;
        priceTag=pt;
        priceValue=pv;
        ratingBar=rb;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(String priceTag) {
        this.priceTag = priceTag;
    }

    public int getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(int priceValue) {
        this.priceValue = priceValue;
    }

    public int getRatingBar() {
        return ratingBar;
    }

    public  void setRatingBar(int ratingBar) {
        this.ratingBar = ratingBar;
    }
}
