package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;

import com.latlng.bolt.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding activitySignupBinding;
    boolean val=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignupBinding= DataBindingUtil.setContentView(this,R.layout.activity_signup);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pass = activitySignupBinding.pEt.getText().toString();
                if(pass.length()>8){
                    activitySignupBinding.showHide.setVisibility(View.VISIBLE);
                }
                else if(pass.length()<8){
                    activitySignupBinding.showHide.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        activitySignupBinding.pEt.addTextChangedListener(textWatcher);

        activitySignupBinding.showHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(val){
                    activitySignupBinding.pEt.setTransformationMethod(new PasswordTransformationMethod());
                    val=false;
                }
                else{
                    activitySignupBinding.pEt.setTransformationMethod(null);
                    val=true;
                }
            }
        });



        activitySignupBinding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        activitySignupBinding.sigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        activitySignupBinding.siBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = activitySignupBinding.nameEt.getText().toString();
                String name = activitySignupBinding.eEt.getText().toString();
                String pass = activitySignupBinding.pEt.getText().toString();

                if(name.length()==0){
                    activitySignupBinding.eEt.requestFocus();
                    activitySignupBinding.eEt.setError("Fields can't be empty!");
                }
                else if(mail.length()==0){
                    activitySignupBinding.nameEt.requestFocus();
                    activitySignupBinding.nameEt.setError("Fields can't be empty!");
                }
                else if(!mail.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                    activitySignupBinding.nameEt.requestFocus();
                    activitySignupBinding.nameEt.setError("Enter valid mail!");
                }
                else if(pass.length()==0){
                    activitySignupBinding.pEt.requestFocus();
                    activitySignupBinding.pEt.setError("Fields can't be empty!");
                }
                else if(pass.length()<8){
                    activitySignupBinding.pEt.requestFocus();
                    activitySignupBinding.pEt.setError("Password must be 8!");
                }
                else{
                    Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });





    }
}