package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.latlng.bolt.databinding.ActivityPaymentBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class PaymentActivity extends AppCompatActivity {
    ActivityPaymentBinding binding;
    VisaAdapter visaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_payment);

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(R.drawable.visacard,R.drawable.visacard,R.drawable.visacard));
        visaAdapter = new VisaAdapter(arrayList);
        binding.visaVP.setAdapter(visaAdapter);

        binding.coutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentActivity.this,CheckoutActivity.class);
                startActivity(intent);
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}