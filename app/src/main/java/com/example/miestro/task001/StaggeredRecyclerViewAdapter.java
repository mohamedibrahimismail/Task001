package com.example.miestro.task001;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by MIESTRO on 18/07/2018.
 */

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder> {


    private static final String TAG = "StaggeredRecyclerViewAd";
    Switch aSwitch;
    private ArrayList<Model> content_list=new ArrayList<Model>();
    private Context mContext;

    public StaggeredRecyclerViewAdapter(Context mContext , ArrayList<Model> content_list) {
        this.content_list = content_list;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);

        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Log.d(TAG,"onBindViewHolder");
       // holder.image.setMinimumHeight(Integer.parseInt(content_list.get(position).getHeight()));
      /*  RequestOptions requestOptions = new RequestOptions()
        .placeholder(R.mipmap.ic_launcher);
        Glide.with(mContext)
                .load(content_list.get(position).getImage())
                .apply(requestOptions)
                .into(holder.image);*/
        Picasso.with(mContext).load(content_list.get(position).getPhoto()).into(holder.category_image);
        Typeface font = Typeface.createFromAsset(mContext.getAssets(),"fonts/GE Dinar One Medium.ttf");
        holder.category_type.setTypeface(font);

        final  String title;

        if(Locale.getDefault().getLanguage().equals("ar")){
            title = content_list.get(position).getTitleAR();

        }else {
            title = content_list.get(position).getTitleEN();

        }

        holder.category_type.setText(title);

        holder.category_count.setText("("+content_list.get(position).getProductCount()+")");


      holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: "+position);
          //      Toast.makeText(mContext,position+"", Toast.LENGTH_SHORT).show();

                aSwitch = (Switch)mContext;
                aSwitch.Switc_fragment(position+"",title);


            }
        });

    }

    @Override
    public int getItemCount() {
        return content_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    ImageView category_image;
    TextView category_type;
    TextView category_count;
    RelativeLayout container;

    public ViewHolder(View itemView) {
        super(itemView);
        this.category_image = (ImageView) itemView.findViewById(R.id.category_image);
        this.category_type = (TextView) itemView.findViewById(R.id.category_type);
        this.category_count = (TextView) itemView.findViewById(R.id.category_count);
        this.container = (RelativeLayout)itemView.findViewById(R.id.container);
    }
}
}
