package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.latlng.bolt.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_menu);

        binding.backCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        binding.proTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intr = new Intent(MenuActivity.this,ProfileActivity.class);
                startActivity(intr);
            }
        });
        binding.favTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fav = new Intent(MenuActivity.this, SeeAllActivity.class);
                startActivity(fav);
            }
        });
        binding.homeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hom = new Intent(MenuActivity.this,HomeActivity.class);
                startActivity(hom);
            }
        });
        binding.cartTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hom = new Intent(MenuActivity.this,CartActivity.class);
                startActivity(hom);
            }
        });
        binding.ordTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hom = new Intent(MenuActivity.this,CheckoutActivity.class);
                startActivity(hom);
            }
        });
    }
}