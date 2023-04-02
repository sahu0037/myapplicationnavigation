package com.example.myapplicationnavigation.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationnavigation.MainActivity;
import com.example.myapplicationnavigation.MainNavigationActivity;
import com.example.myapplicationnavigation.databinding.FragmentProfileBinding;
import com.example.myapplicationnavigation.ui.home.HomeViewModel;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ImageView imageView = binding.profileImage;
        profileViewModel.getText().observe(getViewLifecycleOwner(), imageView::setContentDescription);

//        final TextView textView = binding.emailField;
//        profileViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final EditText editText = binding.passwordField;
        profileViewModel.getText().observe(getViewLifecycleOwner(), editText::setText);

        final Button button1 = binding.changePasswordButton;
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
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