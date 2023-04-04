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

    public void forgotUsername(View view){
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        navController.navigate(R.id.nav_forgot_username);
        Intent intent = new Intent(this, ForgotUsername.class);
        startActivity(intent);
    }

    public void forgotPassword(View view){
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        navController.navigate(R.id.nav_forgot_password);
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }
}