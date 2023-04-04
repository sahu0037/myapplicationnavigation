package com.example.myapplicationnavigation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //a list to store all the products


    //the recycrview
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void sendMessage(View view){
            Intent intent = new Intent(this, MainNavigationActivity.class);
            EditText editTest = (EditText) findViewById(R.id.Username);
            String message = editTest.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    public void sendMessageSignUp(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}