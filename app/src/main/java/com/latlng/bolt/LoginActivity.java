package com.latlng.bolt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;

import com.latlng.bolt.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding activityLoginBinding;
    int val=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pass = activityLoginBinding.pEt.getText().toString();
                if(pass.length()>8){
                    activityLoginBinding.showHide.setVisibility(View.VISIBLE);
                }
                else if(pass.length()<8){
                    activityLoginBinding.showHide.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        activityLoginBinding.pEt.addTextChangedListener(textWatcher);
        activityLoginBinding.showHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(val==0){
                    activityLoginBinding.pEt.setTransformationMethod(null);
                    val=1;
                }
                else{
                    activityLoginBinding.pEt.setTransformationMethod(new PasswordTransformationMethod());
                    val=0;
                }

            }
        });

        activityLoginBinding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        activityLoginBinding.sinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sup = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(sup);
            }
        });

        activityLoginBinding.logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = activityLoginBinding.eEt.getText().toString();
                String pass = activityLoginBinding.pEt.getText().toString();

                if(email.length()==0){
                    activityLoginBinding.eEt.requestFocus();
                    activityLoginBinding.eEt.setError("Fields can't be empty!");
                }
                else if(!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                    activityLoginBinding.eEt.requestFocus();
                    activityLoginBinding.eEt.setError("Enter valid mail!");
                }
                else if(pass.length()==0){
                    activityLoginBinding.pEt.requestFocus();
                    activityLoginBinding.pEt.setError("Fields can't be empty!");
                }
                else if(pass.length()<8){
                    activityLoginBinding.pEt.requestFocus();
                    activityLoginBinding.pEt.setError("Password must be 8!");
                }
                else{
                    Intent back = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(back);
                }
            }
        });






    }
}