package com.example.myapplicationnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public  class SecondActivity extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        Intent intent=getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    }
    public void sendMessageToHome(View view){
        EditText e = (EditText) findViewById(R.id.username);
        EditText e1 = (EditText) findViewById(R.id.password);
        if (e.getText().toString().equals("") && e.getText().length() <= 0){
            e.setError("Username can't be empty");
        }
        else if (e1.getText().toString().equals("") && e1.getText().length() <= 0){
            e1.setError("Password can't be empty");
        }
        else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}