package com.dharani.navigationdemo.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.dharani.navigationdemo.activity.ProductListActivity;
import com.dharani.navigationdemo.adapter.HomeAdapter;
import com.dharani.navigationdemo.adapter.ProductAdapter;
import com.dharani.navigationdemo.pojo.CategoryFetchEvent;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by gopinath on 03/07/17.
 */

public class Category extends AsyncTask<String, Void, String> {

String department,cat_id,category,status;
    String url = "http://www.gopinath.pe.hu/category.php";
    ArrayList depart,catid,categ,stat=new ArrayList();
Context context;
    @Override
    protected String doInBackground(String... params) {
        RequestBody body;
        Response response;
        String jsondata = null;

        OkHttpClient client = new OkHttpClient();

        body = new FormBody.Builder()
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                jsondata = response.body().string();
                Log.d("DATA", jsondata);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsondata;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

    protected void onPostExecute(String jsondata)
    {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsondata);
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            if (jsonArray != null) {

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String id = object.getString("id");
                    String dept = object.getString("department");
                    String cat = object.getString("cat_id");
                    String category = object.getString("category");

                    Log.e("Category name ",""+category);
//                    department = object.getString("department");
//                    if (department.equals(HomeAdapter.dept)) {
//                        cat_id = object.getString("cat_id");
//                        category = object.getString("category");
//                        status = object.getString("status");
//                        depart.add(department);
//                        catid.add(cat_id);
//                        categ.add(category);
//                        stat.add(status);
//                        new ProductListActivity(depart,catid,categ,stat);
//                    }
//                    else
//                    {
//                        Toast.makeText(context,"Something Went Wrong! Please Try again",Toast.LENGTH_LONG).show();
//                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
