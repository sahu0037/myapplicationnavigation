package com.example.myapplicationnavigation.ui.forgotPassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationnavigation.databinding.ForgotPasswordBinding;
import com.example.myapplicationnavigation.databinding.ForgotUsernameBinding;

public class ForgotPasswordFragment extends Fragment {

    private ForgotPasswordBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ForgotPasswordViewModel changePasswordViewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);

        binding = ForgotPasswordBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}