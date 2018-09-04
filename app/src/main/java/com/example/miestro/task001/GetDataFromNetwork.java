package com.example.miestro.task001;

import android.content.Context;
import android.util.Log;
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
 * Created by MIESTRO on 04/09/2018.
 */

public class GetDataFromNetwork {

    private  ArrayList<Model> content_list=new ArrayList<Model>();
    private RequestQueue requestQueue;
    private String json_Url;
    private Context context;

    public GetDataFromNetwork(Context context,String json_Url){
        this.context = context;
        this.json_Url = json_Url;
    }

    public  void getListData(){


        requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,json_Url,
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

/*
                                String id=respons.getString("id");
                                String productDescription=respons.getString("productDescription");
                                String price=respons.getString("price");
                                JSONObject image = respons.getJSONObject("image");
                                String url = image.getString("url");
                                String height  = image.getString("height");
*/
                                content_list.add(new Model(id,TitleEN,TitleAR,photo,ProductCount,havemodel,Subcategories));

                            }

                            if(content_list.size()>0) {
                                //    Toast.makeText(getActivity(),""+content_list.size(),Toast.LENGTH_SHORT).show();

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
               // Toast.makeText(getActivity(),"Volley error",Toast.LENGTH_SHORT).show();
            }
        });


        requestQueue.add(jsonArrayRequest);
        //  return content_list;


    }


    public ArrayList<Model> getContent_list(){

        return this.content_list;
    }

}
