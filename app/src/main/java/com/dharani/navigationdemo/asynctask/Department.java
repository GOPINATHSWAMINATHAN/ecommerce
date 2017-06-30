package com.dharani.navigationdemo.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dharani.navigationdemo.R;
import com.dharani.navigationdemo.data.MyData;
import com.dharani.navigationdemo.fragment.HomeFragment;
import com.dharani.navigationdemo.pojo.FetchCompletedEvent;
import com.squareup.picasso.Downloader;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by gopinath on 27/06/17.
 */

public class Department extends AsyncTask<String, Void, String> {
    MyData obj = new MyData();
    Context context;
    String url = "http://www.gopinath.pe.hu/department.php";
    String urlRetrieve = "http://www.silverlightsystems.co.uk/android/json.php";
    public static String store1, store2;
    public static ArrayList<String> dept = new ArrayList();
    public static ArrayList<String> id = new ArrayList();
    public static ArrayList<MyData> al = new ArrayList<>();
    private View rootView;

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }

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
    protected void onPostExecute(String jsondata) {
        //super.onPostExecute(s);
        try {

            JSONObject jsonObject = new JSONObject(jsondata);
            JSONArray jsonArray = jsonObject.getJSONArray("result");

            if (jsonArray != null) {
                Log.d("Testing : ", "" + jsonArray);
                for (int i = 0; i < 4; i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    // store1 = object.getString(obj.getProductName("department"));

                    store1 = object.getString("dept_id");
                    store2 = object.getString("department");
//
//                    store1 = object.getString("id");
//                    store2 = object.getString("name");

                    Log.e("Retrieve ID data : ", "ID -> " + store1);
                    Log.e("Retrieve NAME data : ", "Name -> " + store2);

//TextView ce=(TextView)rootView.findViewById(R.id.textView_ID);
//                    TextView me=(TextView)rootView.findViewById(R.id.dept_id);
                    dept.add(store1);
                    id.add(store2);
                    EventBus.getDefault().post(new FetchCompletedEvent(dept,id));
//                    ce.setText(dept.get(i));
//                    me.setText(id.get(i));
                }
                System.out.println(dept);
                System.out.println(id);
            } else {
                Toast.makeText(context, "Values are null in array", Toast.LENGTH_LONG).show();
                Log.e("ARRAY DETAILS", "" + jsonArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
