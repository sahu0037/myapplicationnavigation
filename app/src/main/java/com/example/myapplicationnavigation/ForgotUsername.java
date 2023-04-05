package com.example.myapplicationnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplicationnavigation.databinding.ActivityMainNavigationBinding;
import com.example.myapplicationnavigation.databinding.ForgotUsernameBinding;

public  class ForgotUsername extends AppCompatActivity {

    private ForgotUsernameBinding binding;
    //public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_username);
        binding = ForgotUsernameBinding.inflate(getLayoutInflater());
    }
    public void sendMessageToHome(View view) {
        EditText e1 = (EditText) findViewById(R.id.phone);
        if (e1.getText().toString().equals("") && e1.getText().length() <= 0) {
            e1.setError("Phone number can't be empty");
        } else {
            ((TextView) findViewById(R.id.confirmation)).setText("A message with your username has been sent to your phone number");
        }
    }
}