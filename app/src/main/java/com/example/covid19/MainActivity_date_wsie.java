package com.example.covid19;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_date_wsie extends AppCompatActivity {
    private static final String URL_DATA="https://api.covid19india.org/data.json";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<date_wise> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems=new ArrayList<>();

        loadRecyclerViewData();

    }
    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.GET,URL_DATA,new Response.Listener<String>()
        {
            public void onResponse(String s)
            {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(s);
                    JSONArray array=jsonObject.getJSONArray("cases_time_series");

                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject obj=array.getJSONObject(i);
                        date_wise item=new date_wise( obj.getString("date"), obj.getString("dailyconfirmed"), obj.getString("dailydeceased"), obj.getString("dailyrecovered")
                        , obj.getString("totalconfirmed"), obj.getString("totaldeceased"), obj.getString("totalrecovered"));
                        listItems.add(item);
                    }
                    adapter=new MyAdapter_date_wise(listItems,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener()
        {
            public void onErrorResponse(VolleyError volleyError)
            {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
