package com.example.razer_pay_testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_click_pay);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkout checkout = new Checkout();

                checkout.setKeyID("rzp_test_thMvIr98nRXGp4");

                JSONObject object = new JSONObject();

                try {
                    object.put("name","speaker");
                    object.put("descriptiin","Boat");
                    object.put("amount",24000f);
                    checkout.open(MainActivity.this,object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {

        Toast.makeText(this, "succesfull", Toast.LENGTH_SHORT).show();
        Log.d("mydata","order id : "+s);
    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(this, "Payment Failed", Toast.LENGTH_SHORT).show();
        Log.d("mydata","order id :"+s);
    }
}