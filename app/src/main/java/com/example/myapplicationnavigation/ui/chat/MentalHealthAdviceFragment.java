package com.example.myapplicationnavigation.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplicationnavigation.R;

public class MentalHealthAdviceFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mental_health_advice_fragment, container, false);

        // Enable the back button
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {

            public void handleOnBackPressed() {
                requireActivity().onBackPressed();
            }
        });

        // Initialize the UI components
        TextView titleTextView = root.findViewById(R.id.title_text_view);
        TextView descriptionTextView = root.findViewById(R.id.description_text_view);
        ImageButton backButton = (ImageButton) root.findViewById(R.id.back_button);


        // Set the text for the title and description
        titleTextView.setText("Tips for Taking Care of Your Mental Health");
        descriptionTextView.setText("1. Connect with others\n" +
                "2. Stay active\n" +
                "3. Take breaks\n" +
                "4. Practice relaxation techniques\n" +
                "5. Seek professional help if needed");

        // Set the onClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().onBackPressed();
            }
        });

        return root;
    }
}
