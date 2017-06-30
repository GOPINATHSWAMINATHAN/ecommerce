package com.dharani.navigationdemo.pojo;

import java.util.ArrayList;

/**
 * Created by gopinath on 28/06/17.
 */

public class FetchCompletedEvent {

    public ArrayList<String> dept=new ArrayList();
    public ArrayList<String> id=new ArrayList();

    public FetchCompletedEvent(ArrayList dept,ArrayList id)
    {
        this.dept=dept;
        this.id=id;
    }
}
