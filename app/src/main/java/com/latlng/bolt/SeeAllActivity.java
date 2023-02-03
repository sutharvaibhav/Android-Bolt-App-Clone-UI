package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.latlng.bolt.databinding.ActivitySeeAllBinding;
import com.latlng.bolt.databinding.FeatCardBinding;
import com.latlng.bolt.databinding.HomeHorizontalviewBinding;

import java.util.ArrayList;

public class SeeAllActivity extends AppCompatActivity {


    ActivitySeeAllBinding activitySeeAllBinding;
    FeaturedAdapter featuredAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySeeAllBinding = DataBindingUtil.setContentView(this,R.layout.activity_see_all);

        activitySeeAllBinding.titleTxt.setText(getIntent().getStringExtra("title"));


        Bundle bundle = getIntent().getExtras();
        ArrayList<Block> arrayList = bundle.<Block>getParcelableArrayList("mylist");
        featuredAdapter = new FeaturedAdapter(this, arrayList);
        activitySeeAllBinding.seeAllrView.setAdapter(featuredAdapter);

        activitySeeAllBinding.menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });






    }
}