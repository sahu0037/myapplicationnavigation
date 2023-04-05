package com.example.myapplicationnavigation.ui.changePassword;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplicationnavigation.MainActivity;
import com.example.myapplicationnavigation.R;
import com.example.myapplicationnavigation.databinding.FragmentChangePasswordBinding;

import java.util.zip.Inflater;

public class ChangePasswordFragment extends Fragment {

    private FragmentChangePasswordBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ChangePasswordViewModel changePasswordViewModel = new ViewModelProvider(this).get(ChangePasswordViewModel.class);

        binding = FragmentChangePasswordBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.confirmNewPasswordField;
        changePasswordViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final Button button1 = binding.changeButton;
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}