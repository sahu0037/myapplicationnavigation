package com.example.myapplicationnavigation.ui.home;

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
import com.example.myapplicationnavigation.databinding.FragmentHomeBinding;
import com.example.myapplicationnavigation.R;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final Button button1 = binding.startNewChatButton;
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main);
                navController.navigate(R.id.nav_chat);
            }
        });
        setUsernameSideBar(root);
        return root;
    }

    public void setUsernameSideBar(View root) {
        MainActivity mainActivity = MainActivity.getInstance();
        TextView usernameNavigation = (TextView) root.findViewById(R.id.textView);
        if(usernameNavigation!=null)
            usernameNavigation.setText(mainActivity.getUsername());
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}