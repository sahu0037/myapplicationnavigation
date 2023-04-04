package com.example.myapplicationnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationnavigation.databinding.ActivityMainNavigationBinding;
import com.example.myapplicationnavigation.databinding.FragmentChatHistory1Binding;
import com.example.myapplicationnavigation.ui.chat.ChatViewModel;



public class HistoryActivity1 extends AppCompatActivity {
    private ChatViewModel viewModel;
    private EditText userInput;
    private TextView botResponse;
    private FragmentChatHistory1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentChatHistory1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        viewModel = new ViewModelProvider(this).get(ChatViewModel.class);
//        viewModel.getBotResponseLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(String response) {
//                botResponse.setText(response);
//            }
//        });

//        userInput = binding.userInput;
//        botResponse = binding.botResponse;
//
//        binding.sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String input = userInput.getText().toString().trim().toLowerCase();
//                viewModel.processInput(input);
//                botResponse.append("\nYou: " + input); // new
//                userInput.getText().clear();
//
//            }
//        });


    }
    private MutableLiveData<String> botResponseLiveData = new MutableLiveData<>();

    private String[] botResponses = {
            "Botty: Hey there! How are you feeling today?",
            "Botty: Oh no! That sounds terrible. Do you want some recommendations to reduce your stress?",
            "Nice to meet you!",
            "Goodbye!"
    };

    public void processInput(String input) {
        switch (input) {
            case "hi":
            case "hello":
                botResponseLiveData.setValue(botResponses[0]);
                break;
            case "hey, i'm feeling like i'm dying here in the pile of homework":
                botResponseLiveData.setValue(botResponses[1]);
                break;
            case "nice to meet you":
                botResponseLiveData.setValue(botResponses[2]);
                break;
            case "goodbye":
                botResponseLiveData.setValue(botResponses[3]);
                break;
            default:
                botResponseLiveData.setValue("Sorry, I didn't understand.");
                break;
        }
    }

    public LiveData<String> getBotResponseLiveData() {
        return botResponseLiveData;
    }


}