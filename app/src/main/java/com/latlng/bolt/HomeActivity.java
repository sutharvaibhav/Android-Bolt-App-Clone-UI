package com.latlng.bolt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.latlng.bolt.databinding.ActivityHomeBinding;
import com.latlng.bolt.databinding.ActivitySeeAllBinding;
import com.latlng.bolt.databinding.HomeHorizontalviewBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity{

    ActivityHomeBinding activityHomeBinding;
    CategoryAdapter categoryAdapter;
    ParentClassAdapter parentClassAdapter;
    ArrayList<Subject> subjects =new ArrayList<>();
    ArrayList<Block> featured = new ArrayList<>();
    ArrayList<Block> bestsell = new ArrayList<>();
    ArrayList<Block> trending = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityHomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        activityHomeBinding.sPro.setCursorVisible(false);

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(R.drawable.women_category,R.drawable.men_category,R.drawable.kids_cat));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(R.drawable.women_bg,R.drawable.manbg,R.drawable.kidsbg));
        ArrayList<String> arr3 = new ArrayList<String>(Arrays.asList("Women","Men","Kids"));
        categoryAdapter = new CategoryAdapter(HomeActivity.this,arr,arr2,arr3);
        activityHomeBinding.categories.setAdapter(categoryAdapter);


        Block b11 = new Block(R.drawable.feat1,"$34.00","Woman T-Shirt");
        Block b12 = new Block(R.drawable.feat2,"$29.00","Man T-Shirt");
        Block b13 = new Block(R.drawable.feat3,"$34.00","Woman T-Shirt");
        Block b14 = new Block(R.drawable.feat4,"$34.00","Blezer");
        Block b15 = new Block(R.drawable.feat5,"$34.00","T-Shirt");
        Block b16 = new Block(R.drawable.feat6,"$34.00","Shirt");

        featured.add(b11);
        featured.add(b12);
        featured.add(b13);
        featured.add(b14);
        featured.add(b15);
        featured.add(b16);


        Subject fe = new Subject("Featured",featured);
        subjects.add(fe);



        Block b21=new Block(R.drawable.bs1,"$24.00","Woman T-Shirt");
        Block b22=new Block(R.drawable.bs2,"$44.00","Man T-Shirt");
        Block b23=new Block(R.drawable.bs3,"$34.00","Woman T-Shirt");
        Block b24 = new Block(R.drawable.feat4,"$34.00","Blezer");
        Block b25 = new Block(R.drawable.feat5,"$34.00","T-Shirt");
        Block b26 = new Block(R.drawable.feat6,"$34.00","Shirt");

        bestsell.add(b21);
        bestsell.add(b22);
        bestsell.add(b23);
        bestsell.add(b24);
        bestsell.add(b25);
        bestsell.add(b26);

        Subject bs = new Subject("Best Sell",bestsell);
        subjects.add(bs);



        Block b31 = new Block(R.drawable.feat1,"$34.00","Woman T-Shirt");
        Block b32 = new Block(R.drawable.feat2,"$29.00","Man T-Shirt");
        Block b33 = new Block(R.drawable.feat3,"$34.00","Woman T-Shirt");
        Block b34 = new Block(R.drawable.feat4,"$34.00","Blezer");
        Block b35 = new Block(R.drawable.feat5,"$34.00","T-Shirt");
        Block b36 = new Block(R.drawable.feat6,"$34.00","Shirt");

        trending.add(b31);
        trending.add(b32);
        trending.add(b33);
        trending.add(b34);
        trending.add(b35);
        trending.add(b36);;

        Subject trend = new Subject("Trending",trending);
        subjects.add(trend);



        parentClassAdapter = new ParentClassAdapter(this,subjects);
        activityHomeBinding.mainView.setLayoutManager(new LinearLayoutManager(this));
        activityHomeBinding.mainView.setAdapter(parentClassAdapter);

        activityHomeBinding.menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

    }






}