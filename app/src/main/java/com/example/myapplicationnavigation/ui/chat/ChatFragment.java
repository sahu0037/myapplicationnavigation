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
import androidx.navigation.Navigation;

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
        // Inflate the layout for this fragment
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
        viewModel.getBotResponseLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String response) {
                String prevResponse = botResponse.getText().toString(); // get the previous response
                botResponse.setText(prevResponse + "\n" + "botty: " +response + "\n"); // append the new response to the previous response

                // check if response is "Hey there! How are you feeling today?"
                // if yes, wait for user input
                if (response.equals(ChatViewModel.BOT_RESPONSES[0])) {
                    // Bot response: "Hey there! How are you feeling today?"
                    // Wait for user input
                } else if (response.equals(ChatViewModel.BOT_RESPONSES[1])) {
                    // Bot response: "Oh no! That sounds terrible. Do you want some recommendations to reduce your stress?"
                    Navigation.findNavController(requireView()).navigate(R.id.action_chatFragment_to_mentalHealthAdviceFragment);
                } else if (response.equals(ChatViewModel.BOT_RESPONSES[2])) {
                    // Bot response: "That's great to hear!"
                    // Wait for user input
                } else if (response.equals(ChatViewModel.BOT_RESPONSES[3])) {
                    // Bot response: "Goodbye!"
                    Navigation.findNavController(requireView()).navigateUp();
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
