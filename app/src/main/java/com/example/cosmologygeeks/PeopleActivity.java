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

import java.util.ArrayList;

public class PeopleActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private static String People_Get_API="http://api.open-notify.org/astros.json";
    private RecyclerView recyclerviewid;
    private PeopleAdapter poepleAdapter=null;


    private ArrayList<PeopleDataModel> peopleDataModelArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);


        recyclerviewid=findViewById(R.id.recyclerviewid);
        initList(peopleDataModelArrayList);
        requestQueue=VoleySingleton.getInstance(this).getRequestQueue();
        sendApiRequestinfo();
    }

    private void sendApiRequestinfo() {
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, People_Get_API, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{

                    JSONArray array=response.getJSONArray("people");
                    for(int i=0;i<array.length();i++)
                    {
                        JSONObject jsonObject=array.getJSONObject(i);
                        String name=jsonObject.getString("name");
                        String craftName=jsonObject.getString("craft");
                        PeopleDataModel poepleDataModel=new PeopleDataModel();
                        poepleDataModel.setPeopleName(name);
                        poepleDataModel.setPeopleCraft(craftName);
                        peopleDataModelArrayList.add(poepleDataModel);
                        Log.d("List",name);
                    }
                    poepleAdapter.notifyDataSetChanged();
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

    private void initList(ArrayList<PeopleDataModel> peopleDataModelArrayList) {

        recyclerviewid.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        poepleAdapter=new PeopleAdapter(this, peopleDataModelArrayList);
        recyclerviewid.setAdapter(poepleAdapter);

    }
}
