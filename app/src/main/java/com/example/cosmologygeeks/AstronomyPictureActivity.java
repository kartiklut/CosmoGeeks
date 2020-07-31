package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AstronomyPictureActivity extends AppCompatActivity {


    ImageView imageView;
    TextView title_text,date_text,copyright_text,content_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astronomy_picture);

        imageView=findViewById(R.id.imageView);
        title_text=findViewById(R.id.title);
        date_text=findViewById(R.id.date);
        copyright_text=findViewById(R.id.copyright);
        content_text=findViewById(R.id.content);

        String url="https://api.nasa.gov/planetary/apod?api_key=XiYOCGcUVMHOHFmnN7bbTuxku3MHARScBCQzdiNI";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject_response = new JSONObject(response);
                    String copyright=jsonObject_response.getString("copyright");
                    String date=jsonObject_response.getString("date");
                    String content=jsonObject_response.getString("explanation");
                    String title=jsonObject_response.getString("title");
                    String image_url=jsonObject_response.getString("hdurl");
                    Glide.with( AstronomyPictureActivity.this)
                            .load(image_url)
                            .into(imageView);
                    title_text.setText(title);
                    date_text.setText(date);
                    content_text.setText(content);
                    copyright_text.setText(copyright);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AstronomyPictureActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                super.getHeaders();
                Map<String, String> header = new HashMap<>();
                header.put("Content-Type","application/json");
                return header;
            }
        };
        requestQueue.add(stringRequest);


    }
}
