package com.example.myapplicationnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public  class SecondActivity extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        Intent intent=getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //
        //        TextView textView=(TextView)findViewById(R.id.GetStarted);
        //        textView.setText(message);
    }
    public void sendMessageToHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}