package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class mact1 extends AppCompatActivity {
    RecyclerView rcl;
    Myadapter adapter;
    public static ArrayList<users_cls> employeeArrayList = new ArrayList<>();
    String url = "http://192.168.29.1/LoginRegister/retrieve.php";
    users_cls users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcl = findViewById(R.id.rcl_view);

        List<users_cls> users = new ArrayList<users_cls>();
        adapter = new Myadapter(this, users);


        rcl.setLayoutManager(new LinearLayoutManager(this));
        rcl.setAdapter(adapter);
        retrieveData();
    }
    public void retrieveData(){

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        employeeArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String sucess = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(sucess.equals("1")){


                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);


                                    String name = object.getString("Username");
                                    String pwd = object.getString("Password");
                                    String fn = object.getString("FullName");
                                    String dob = object.getString("DateOfBirth");
                                    String hobby = object.getString("Interests");

                                    users = new users_cls(name,pwd,fn,dob,hobby);
                                    employeeArrayList.add(users);
                                    adapter.notifyDataSetChanged();



                                }



                            }




                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }






                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mact1.this, error.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println(error.toString());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
}}