package com.example.myapplicationnavigation.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import com.example.myapplicationnavigation.HistoryActivity1;
import com.example.myapplicationnavigation.HistoryActivity2;
import com.example.myapplicationnavigation.HistoryActivity3;
import com.example.myapplicationnavigation.MainActivity;
import com.example.myapplicationnavigation.MainNavigationActivity;
import com.example.myapplicationnavigation.R;
import com.example.myapplicationnavigation.databinding.FragmentHistoryBinding;
import com.example.myapplicationnavigation.ui.changePassword.ChangePasswordFragment;
import com.example.myapplicationnavigation.ui.chat.ChatFragment;
import com.example.myapplicationnavigation.ui.chat.ChatViewModel;


public class HistoryFragment extends Fragment{

    private FragmentHistoryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel historyViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button button1 = binding.continueChatButton1;
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.nav_history, new ChangePasswordFragment()).commit();
                startActivity(new Intent(v.getContext(), HistoryActivity1.class));
            }
        });

        final Button button2 = binding.continueChatButton2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), HistoryActivity2.class));
            }
        });

        final Button button3 = binding.continueChatButton3;
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), HistoryActivity3.class));
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