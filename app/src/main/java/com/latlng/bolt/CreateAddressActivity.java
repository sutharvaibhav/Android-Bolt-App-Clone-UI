package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.latlng.bolt.databinding.ActivityCreateAddressBinding;

public class CreateAddressActivity extends AppCompatActivity {

    ActivityCreateAddressBinding activityCreateAddressBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCreateAddressBinding= DataBindingUtil.setContentView(this,R.layout.activity_create_address);

        activityCreateAddressBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        activityCreateAddressBinding.addAddBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = activityCreateAddressBinding.nameEt.getText().toString();
                String addlane = activityCreateAddressBinding.addEt.getText().toString();
                String mail = activityCreateAddressBinding.eEt.getText().toString();
                String postadd = activityCreateAddressBinding.pcEt.getText().toString();
                String pno = activityCreateAddressBinding.pnEt.getText().toString();

                if (name.length()==0){
                    activityCreateAddressBinding.nameEt.requestFocus();
                    activityCreateAddressBinding.nameEt.setError("Fields can't be empty!");
                }
                else if (addlane.length()==0){
                    activityCreateAddressBinding.addEt.requestFocus();
                    activityCreateAddressBinding.addEt.setError("Fields can't be empty!");
                }
                else if (mail.length()==0){
                    activityCreateAddressBinding.eEt.requestFocus();
                    activityCreateAddressBinding.eEt.setError("Fields can't be empty!");
                }
                else if (postadd.length()==0){
                    activityCreateAddressBinding.pcEt.requestFocus();
                    activityCreateAddressBinding.pcEt.setError("Fields can't be empty!");
                }
                else if (pno.length()==0){
                    activityCreateAddressBinding.pnEt.requestFocus();
                    activityCreateAddressBinding.pnEt.setError("Fields can't be empty!");
                }
                else{
                    Intent intent = new Intent(CreateAddressActivity.this , AddressActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}