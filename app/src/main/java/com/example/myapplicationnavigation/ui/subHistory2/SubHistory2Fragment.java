package com.example.myapplicationnavigation.ui.subHistory2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationnavigation.databinding.FragmentChatBinding;
import com.example.myapplicationnavigation.databinding.FragmentChatHistory1Binding;
import com.example.myapplicationnavigation.databinding.FragmentChatHistory2Binding;
import com.example.myapplicationnavigation.ui.subHistory1.SubHistory1ViewModel;
import com.example.myapplicationnavigation.ui.subHistory2.SubHistory2ViewModel;

public class SubHistory2Fragment extends Fragment {
    private SubHistory2ViewModel viewModel;
    private EditText userInput;
    private TextView botResponse;
    private FragmentChatHistory2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatHistory2Binding.inflate(inflater, container, false);

        userInput = binding.userInput;
        botResponse = binding.botResponse;

        binding.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = userInput.getText().toString().trim().toLowerCase();
                viewModel.processInput(input);
                botResponse.append("\nYou: " + input); // new
                userInput.getText().clear();

            }
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SubHistory2ViewModel.class);
        viewModel.getBotResponseLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String response) {
                botResponse.setText(response);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
