package com.example.myapplicationnavigation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private static MainActivity mainActivityInstance;

    private static String username;
    public static MainActivity getInstance(){
        if (mainActivityInstance == null){
            mainActivityInstance = new MainActivity();
        }
        return mainActivityInstance;
    }
    public MainActivity(){

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, MainNavigationActivity.class);
        EditText editTest = (EditText) findViewById(R.id.Username);
        EditText pw = (EditText) findViewById(R.id.Password);
        if (editTest.getText().toString().equals("") && editTest.getText().length() <= 0){
            editTest.setError("Username can't be empty");
        }
        if (pw.getText().toString().equals("") && pw.getText().length() <= 0){
            pw.setError("Password can't be empty");
        }
        else {
            String message = editTest.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            username = editTest.getText().toString();
            System.out.println("--------------------------------username" + username);
            this.setUsername(username);
            startActivity(intent);
        }
    }
    public void sendMessageSignUp(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void forgotUsername(View view){
        Intent intent = new Intent(this, ForgotUsername.class);
        startActivity(intent);
    }

    public void forgotPassword(View view){
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }



}