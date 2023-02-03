package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.latlng.bolt.databinding.ActivityCheckoutBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckoutActivity extends AppCompatActivity {

    ActivityCheckoutBinding binding;
    CartAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_checkout);

        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(R.drawable.cart1,R.drawable.cart2));
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("Woman t- shirt","Female t- shirt"));
        ArrayList<String> arr3 = new ArrayList<>(Arrays.asList("Lotto.LTD","Bata"));
        ArrayList<String> arr4 = new ArrayList<>(Arrays.asList("$34.00","$49.00"));

        adapter = new CartAdapter(this,arr1,arr2,arr3,arr4);
        binding.checkRView.setAdapter(adapter);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.buyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckoutActivity.this,ConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }
}