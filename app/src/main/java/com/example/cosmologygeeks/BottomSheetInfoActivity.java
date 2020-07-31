package com.example.cosmologygeeks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BottomSheetInfoActivity extends BottomSheetDialogFragment {


    private RequestQueue requestQueue;
    private Calendar calendar;
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static Date date = new Date();


    static String end_date=dateFormat.format(date).toString();
    String objectID="";
    private static String NASA_INFO_GET_URL="https://api.nasa.gov/neo/rest/v1/feed?start_date=2020-06-23&end_date=2020-06-25&api_key=XiYOCGcUVMHOHFmnN7bbTuxku3MHARScBCQzdiNI";

    TextView objName,objid,estimatedDia,closeApproach,velocity,missDistance,orbitingBody,hazardous,sentry;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view=inflater.inflate(R.layout.activity_bottom_sheet_info,container,false);
        objName=view.findViewById(R.id.object_name);
        objid=view.findViewById(R.id.object_id);
        estimatedDia=view.findViewById(R.id.object_diameter);
        closeApproach=view.findViewById(R.id.object_approach);
        velocity=view.findViewById(R.id.object_velocity);
        missDistance=view.findViewById(R.id.object_missDistance);
        orbitingBody=view.findViewById(R.id.object_orbitingBody);
        hazardous=view.findViewById(R.id.object_potentiallyHazardous);
        sentry=view.findViewById(R.id.object_santry);


        Bundle mArgs = getArguments();
        objectID = mArgs.getString("ObjectId");
//        Log.d("OBJECT ID ",objectId);


        requestQueue=VoleySingleton.getInstance(getContext()).getRequestQueue();
        sendApiRequestinfo();


        return view;
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
                        String objectId=jsonObject.getString("id");
                        if(objectId.equals(objectID))
                        {
                            String name=jsonObject.getString("name");
                            String refId=jsonObject.getString("neo_reference_id");
                            String estimatedDiameter=jsonObject.getJSONObject("estimated_diameter").getJSONObject("kilometers").getString("estimated_diameter_max");
                            String closestApproach=jsonObject.getJSONArray("close_approach_data").getJSONObject(0).getString("close_approach_date");
                            String relativeVelocity=jsonObject.getJSONArray("close_approach_data").getJSONObject(0).getJSONObject("relative_velocity").getString("kilometers_per_second");
                            String hazard=jsonObject.getString("is_potentially_hazardous_asteroid");
                            String sent=jsonObject.getString("is_sentry_object");
                            String miss=jsonObject.getJSONArray("close_approach_data").getJSONObject(0).getJSONObject("miss_distance").getString("kilometers");
                            String orbit=jsonObject.getJSONArray("close_approach_data").getJSONObject(0).getString("orbiting_body");


                            objName.setText(name);
                            estimatedDia.setText(estimatedDiameter);
                            closeApproach.setText(closestApproach);
                            hazardous.setText(hazard);
                            sentry.setText(sent);
                            velocity.setText(relativeVelocity);
                            objid.setText(refId);
                            missDistance.setText(miss);
                            orbitingBody.setText(orbit);
                        }
                    }
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
}
