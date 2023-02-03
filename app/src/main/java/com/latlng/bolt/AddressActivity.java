package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.latlng.bolt.databinding.ActivityAddressBinding;

import java.util.ArrayList;

public class AddressActivity extends AppCompatActivity {

    ArrayList<AddressModel> address = new ArrayList<>();
    ActivityAddressBinding activityAddressBinding;
    AddressAdapter addressAdapter;
    ItemClickListener itemClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddressBinding = DataBindingUtil.setContentView(this,R.layout.activity_address);



        AddressModel address1 = new AddressModel("Shewrapara, Mirpur, Dhaka-1216","House no: 938","Road no: 9");
        AddressModel address2 = new AddressModel("Chatkhil, Noakhali","House no: 22","Road no: 7");
        address.add(address1);
        address.add(address2);

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add("RB " + i);
        }

        itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(String s) {
                activityAddressBinding.addView.post(new Runnable() {
                    @Override
                    public void run() {
                        addressAdapter.notifyDataSetChanged();
                    }
                });

            }
        };

        addressAdapter = new AddressAdapter(address, this,itemClickListener);
        activityAddressBinding.addView.setAdapter(addressAdapter);

        activityAddressBinding.addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(AddressActivity.this,CreateAddressActivity.class);
                startActivity(add);
            }
        });

        activityAddressBinding.menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        activityAddressBinding.payBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}