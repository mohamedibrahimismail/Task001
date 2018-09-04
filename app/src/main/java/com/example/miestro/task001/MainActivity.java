package com.example.miestro.task001;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements Switch,Switch2 {
    FragmentManager manager;
    ImageView logo;
    TextView subcategorie_title;
    ImageButton backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        logo = (ImageView)findViewById(R.id.logo);
        subcategorie_title = (TextView)findViewById(R.id.subcategorie_title);
        backbutton = (ImageButton)findViewById(R.id.back_arrow);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.popBackStack();
            }
        });
        setSupportActionBar(toolbar);
        setTitle(null);

        manager = getFragmentManager();



        ReplaceBwithA();

    }

    public void ReplaceAwithB(String category_id){

        Bundle bundle = new Bundle();
        bundle.putString("category_id", category_id);
        Fragment_B f = new Fragment_B();
        f.setArguments(bundle);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment,f,"B");
        transaction.addToBackStack("ReplaceAwithB");
        transaction.commit();

    }

    public void ReplaceBwithA(){


        Fragment_A f = new Fragment_A();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment,f,"A");
      //  transaction.addToBackStack("ReplaceBwithA");
        transaction.commit();

    }

    public void setupSubcategorie_header(String category){

        logo.setVisibility(View.GONE);
        subcategorie_title.setText(category);
        subcategorie_title.setVisibility(View.VISIBLE);
        backbutton.setVisibility(View.VISIBLE);
        Typeface font = Typeface.createFromAsset(this.getAssets(),"fonts/GE Dinar One Medium.ttf");
        subcategorie_title.setTypeface(font);

    }

    public void setupSubcategorie_header2(){

        subcategorie_title.setText("");
        subcategorie_title.setVisibility(View.GONE);
        backbutton.setVisibility(View.GONE);
        logo.setVisibility(View.VISIBLE);

    }

    @Override
    public void Switc_fragment(String id,String Category) {
       // Toast.makeText(MainActivity.this,id, Toast.LENGTH_SHORT).show();
        setupSubcategorie_header(Category);
        ReplaceAwithB(id);
    }

    @Override
    public void do_switch() {
        setupSubcategorie_header2();
    }
}
