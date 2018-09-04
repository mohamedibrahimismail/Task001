package com.example.miestro.task001;

import android.widget.Toast;

import java.util.Locale;

/**
 * Created by MIESTRO on 04/09/2018.
 */

public class Localization {

    public  static String getDefaultLanguage(){

        String x =null;

        if(Locale.getDefault().getLanguage().equals("en")){
           x="en";
        }else if(Locale.getDefault().getLanguage().equals("ar")){
           x = "ar";
        }else{
           x = "unknown";
        }
        return x;
    }
}
