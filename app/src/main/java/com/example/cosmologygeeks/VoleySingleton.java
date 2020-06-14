package com.example.cosmologygeeks;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VoleySingleton {

    private static VoleySingleton singleton;
    private RequestQueue requestQueue;

    public VoleySingleton(Context context) {
        requestQueue= Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VoleySingleton getInstance(Context context){
        if(singleton==null){
            singleton=new VoleySingleton(context);
        }
        return  singleton;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
