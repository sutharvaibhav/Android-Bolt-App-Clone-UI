package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.latlng.bolt.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding activityCartBinding;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCartBinding = DataBindingUtil.setContentView(this,R.layout.activity_cart);

        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(R.drawable.cart1,R.drawable.cart2,R.drawable.cart3,R.drawable.cart4,R.drawable.cart5,R.drawable.feat1,R.drawable.feat2,R.drawable.feat3,R.drawable.feat4,R.drawable.feat5));
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("Woman t- shirt","Female t- shirt","Shirt","Woman Shirt","Shirt","Woman t- shirt","Female t- shirt","Shirt","Woman Shirt","Shirt"));
        ArrayList<String> arr3 = new ArrayList<>(Arrays.asList("Lotto.LTD","Bata","Next","plus point","Next","Lotto.LTD","Bata","Next","plus point","Next"));
        ArrayList<String> arr4 = new ArrayList<>(Arrays.asList("$34.00","$49.00","$64.00","$33.00","$44.00","$34.00","$49.00","$64.00","$33.00","$44.00"));

        cartAdapter = new CartAdapter(this,arr1,arr2,arr3,arr4);
        activityCartBinding.carRV.setAdapter(cartAdapter);

        activityCartBinding.cBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this,AddressActivity.class);
                startActivity(intent);
            }
        });
        activityCartBinding.menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}