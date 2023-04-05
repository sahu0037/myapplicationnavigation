package com.example.myapplicationnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public  class ForgotPassword extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        Intent intent=getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //
        //        TextView textView=(TextView)findViewById(R.id.GetStarted);
        //        textView.setText(message);
    }
    public void sendMessageToHome(View view){
        ((TextView)findViewById(R.id.confirmation)).setText("A message with a link to change password has been sent to your phone number");
    }
}