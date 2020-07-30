package com.example.cosmologygeeks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class RazorPayActivity extends AppCompatActivity implements PaymentResultListener {

    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razor_pay);

        Checkout.preload(getApplicationContext());

        pay=findViewById(R.id.btn_pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupPayment();
            }
        });

    }
    private void setupPayment() {

        final Activity activity=this;
        final Checkout checkout=new Checkout();

        JSONObject object=new JSONObject();
        try {
            object.put("name","CosmoGeeks");
            object.put("description","This is for my Application");
            object.put("image"," "+R.drawable.rzp);
            object.put("currency","INR");
            object.put("amount","100");

            JSONObject prefill=new JSONObject();
            prefill.put("email","kartik17csu088@ncuindia.edu");
            prefill.put("contact","8700873237");
            object.put("prefill",prefill);

            checkout.open(activity, object);
        } catch (JSONException e) {

            Toast.makeText(this, "Exception "+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }

    @Override
    public void onPaymentSuccess(String razorpayId) {
        Toast.makeText(this, "Payment Successfull "+razorpayId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed "+s, Toast.LENGTH_SHORT).show();
    }
}
