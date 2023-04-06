package com.example.myapplicationnavigation.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationnavigation.R;
import com.example.myapplicationnavigation.databinding.FragmentChatBinding;

public class ChatFragment extends Fragment {

    private ChatViewModel viewModel;
    private EditText userInput;
    private TextView botResponse;
    private FragmentChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChatBinding.inflate(inflater, container, false);

        userInput = binding.userInput;
        botResponse = binding.botResponse;

        binding.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = userInput.getText().toString().trim().toLowerCase();
                botResponse.append("\nYou: " + input); // append user input to the bot response TextView
                viewModel.processInput(input);
                userInput.getText().clear();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ChatViewModel.class);
        viewModel.getBotMessageLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String botMessage) {
                if (viewModel.isWaitingForInput()) {
                    // If the bot is waiting for input, append the user input to the bot response TextView
//                    botResponse.append("\nYou: " + userInput.getText().toString());
                }
                // Append the bot message to the bot response TextView
                botResponse.append("\nBotty: " + botMessage);
            }
        });
    }

}
