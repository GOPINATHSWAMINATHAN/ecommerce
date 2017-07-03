package com.dharani.navigationdemo.pojo;

import java.util.ArrayList;

/**
 * Created by gopinath on 03/07/17.
 */

public class CategoryFetchEvent {

    public ArrayList<String> department = new ArrayList();
    public ArrayList<String> cat_id = new ArrayList();
    public ArrayList<String> category = new ArrayList();
    public ArrayList<String> id = new ArrayList();

    public CategoryFetchEvent(ArrayList dept, ArrayList cat_id, ArrayList category, ArrayList id) {
        this.department = dept;
        this.cat_id = cat_id;
        this.category = category;
        this.id = id;

    }
}
