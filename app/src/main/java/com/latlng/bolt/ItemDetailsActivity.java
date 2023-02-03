package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.latlng.bolt.databinding.ActivityItemDetailsBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemDetailsActivity extends AppCompatActivity {

    ImageSliderAdapter imageSliderAdapter;
    ActivityItemDetailsBinding activityItemDetailsBinding;
    ItemClickListener itemClickListener;
    SizeAdapter sizeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityItemDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_item_details);

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(R.drawable.slider,R.drawable.slider,R.drawable.slider));
        imageSliderAdapter = new ImageSliderAdapter(arrayList);
        activityItemDetailsBinding.imageViewr.setAdapter(imageSliderAdapter);
        activityItemDetailsBinding.indicator.setupWithViewPager(activityItemDetailsBinding.imageViewr,true);
        activityItemDetailsBinding.oldPrice.setPaintFlags(activityItemDetailsBinding.oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        activityItemDetailsBinding.addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetailsActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<String> arrayList1 = new ArrayList<>();
        for(int i=0;i<20;i++){
            arrayList1.add("RB "+ i );
        }

        itemClickListener = new ItemClickListener() {

            @Override
            public void onClick(String s) {
                activityItemDetailsBinding.sizeView.post(new Runnable() {
                    @Override
                    public void run() {
                       sizeAdapter.notifyDataSetChanged();
                    }
                });

            }
        };

        ArrayList<String> sizeList = new ArrayList<>(Arrays.asList("S","M","L","XXL"));
        sizeAdapter=new SizeAdapter(this,sizeList,itemClickListener);
        activityItemDetailsBinding.sizeView.setAdapter(sizeAdapter);

        activityItemDetailsBinding.menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
