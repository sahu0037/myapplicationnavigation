package com.example.myapplicationnavigation.ui.forgotUserName;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationnavigation.databinding.ForgotUsernameBinding;
import com.example.myapplicationnavigation.databinding.FragmentChangePasswordBinding;

public class ForgotUsernameFragment extends Fragment {

    private ForgotUsernameBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ForgotUsernameViewModel changePasswordViewModel = new ViewModelProvider(this).get(ForgotUsernameViewModel.class);

        binding = ForgotUsernameBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}