package com.dharani.navigationdemo.data;

import com.dharani.navigationdemo.R;

import java.util.ArrayList;

/**
 * Created by LENOVO on 06/21/17.
 */

public class MyData {

    public String getProductName()
    {
        return productName;
    }

    public String getId()
    {
        return id;
    }

    public static String id;

    public static int[] flipperImages = {R.drawable.ecommerce, R.drawable.electronics, R.drawable.furniture};

    public static String[][] programs = new String[50][];

    public static int pos;

    public static String productName;

//    public static String[] productImage = {
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg",
//            "http://api.androidhive.info/json/movies/1.jpg"
//    };

    static {
        programs[0] = new String[]{"Mobile", "Mobile Accessories", "Smart Wearable tech", "Laptop", "Desktop PCs", "Gaming & Accessories", "Tablets", "Televisions", "Home Entertainment", "Mobile", "Mobile Accessories", "Smart Wearable tech", "Laptop", "Desktop PCs", "Gaming & Accessories", "Tablets", "Televisions", "Home Entertainment"};
        programs[1] = new String[]{"Televisions", "Washing Machine", "Refrigerators", "Air Conditioners", "Geysers", "Kitchen Appliances", "Small Home Appliances", "Smart Home Appliances", "Health Care Appliances", "Buying Guides"};
        programs[2] = new String[]{"Entrance Exams", "Academic", "Literature and Fiction", "Indian Writing", "Biographies", "Children", "Business", "Self Help", "Comics", "Stationery", "Pens", "Diaries", "Key chains", "Desk Organisers", "Calculators"};
        programs[3] = new String[]{"T-Shirts", "Shirts", "Kurtas", "Suits & Blazers", "Jackets", "Sweatshirts", "Jeans", "Trousers", "Cargos", "Track pants", "Sports T-shirts", "Track Pants", "Track Suits", "Shorts", "Vests", "Boxers"};
        programs[4] = new String[]{"Hello World", "Compound Interest", "Area Of Circle", "Swapping Program", "Leap Year", "Perfect Number", "Palindrome", "Reverse", "Factorial", "ArmStrong"};
        programs[5] = new String[]{"Hello World", "Compound Interest", "Area Of Circle", "Swapping Program", "Leap Year", "Perfect Number", "Palindrome", "Reverse", "Factorial", "ArmStrong"};

    }

}
