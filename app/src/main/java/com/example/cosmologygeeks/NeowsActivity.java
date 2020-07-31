package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NeowsActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private Calendar calendar;
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static Date date = new Date();


    static String end_date=dateFormat.format(date).toString();
    private static String NASA_INFO_GET_URL="https://api.nasa.gov/neo/rest/v1/feed?start_date=2020-06-23&end_date=2020-06-25&api_key=XiYOCGcUVMHOHFmnN7bbTuxku3MHARScBCQzdiNI";
    private RecyclerView recyclerviewid;
    private InfoNameAdapter infoNameAdapter=null;


    private ArrayList<NasaInfoDataModel> nasaInfoDataModelArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neows);


        recyclerviewid=findViewById(R.id.recyclerviewid);
        initList(nasaInfoDataModelArrayList);
        requestQueue=VoleySingleton.getInstance(this).getRequestQueue();
        sendApiRequestinfo();
    }
    private void sendApiRequestinfo() {
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, NASA_INFO_GET_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{

                    JSONArray array=response.getJSONObject("near_earth_objects").getJSONArray("2020-06-24");
                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject jsonObject=array.getJSONObject(i);
                        String name=jsonObject.getString("name");
                        String refId=jsonObject.getString("neo_reference_id");
                        String objectId=jsonObject.getString("id");
                        NasaInfoDataModel nasaInfoDataModel=new NasaInfoDataModel();
                        nasaInfoDataModel.setmObjectId(objectId);
                        nasaInfoDataModel.setmNeoRefId(refId);
                        nasaInfoDataModel.setmName(name);
                        nasaInfoDataModelArrayList.add(nasaInfoDataModel);
                        Log.d("List",name);
                    }
                    infoNameAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Log.d("in sendApiRequest","Here!!!!");
        request.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));

        requestQueue.add(request);


    }

    private void initList(ArrayList<NasaInfoDataModel> nasaInfoDataModelArrayList) {

        recyclerviewid.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        infoNameAdapter=new InfoNameAdapter(this, nasaInfoDataModelArrayList);
        recyclerviewid.setAdapter(infoNameAdapter);

    }
}
