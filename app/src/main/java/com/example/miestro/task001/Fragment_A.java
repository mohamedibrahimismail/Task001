package com.example.miestro.task001;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by MIESTRO on 27/01/2018.
 */

public class Fragment_A extends Fragment {

    ArrayList<Model> content_list=new ArrayList<Model>();
    RequestQueue requestQueue;
    String Json_Url ="http://souq.hardtask.co/app/app.asmx/GetCategories?categoryId=0&countryId=1";

    View myfragment;
    Switch2 switch2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d("vivz","Fragment A onCreateView");
        myfragment =  inflater.inflate(R.layout.fragment_a,container,false);

        return myfragment;

    }


    @Override
    public void onResume() {
        super.onResume();
        switch2 = (Switch2)getActivity();
        switch2.do_switch();



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("vivz","Fragment A onActivityCreated");


        getlist();



    }

    public void getlist(){


        content_list.clear();
        requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,Json_Url,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            //  textView.setText(response+"");
                            for(int i=0;i<response.length();i++){

                                JSONObject respons = response.getJSONObject(i);

                                String id=respons.getString("Id");
                                String TitleEN=respons.getString("TitleEN");
                                String TitleAR=respons.getString("TitleAR");
                                String photo=respons.getString("Photo");
                                String ProductCount=respons.getString("ProductCount");
                                String havemodel=respons.getString("HaveModel");
                                Model Subcategories=null;

                                content_list.add(new Model(id,TitleEN,TitleAR,photo,ProductCount,havemodel,Subcategories));

                            }

                            if(content_list.size()>0) {
                            //    Toast.makeText(getActivity(),""+content_list.size(),Toast.LENGTH_SHORT).show();
                                displaylist();
                              /*  adapter = new RecyclerAdapter(content_list, Display_List.this);
                                recyclerView.setAdapter(adapter);*/
                              //  dispaly(content_list);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }},new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley","error======================="+error.getMessage());
                Toast.makeText(getActivity(),"Volley error",Toast.LENGTH_SHORT).show();
            }
        });


        requestQueue.add(jsonArrayRequest);
        //  return content_list;



    }


    public void displaylist(){
        RecyclerView recyclerView = (RecyclerView)myfragment.findViewById(R.id.recyclerView);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter = new StaggeredRecyclerViewAdapter(getActivity(),content_list);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);

    }


}
