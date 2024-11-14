package com.example.owner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ComboFragment  extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_combo, container, false);

        TextView others = view.findViewById(R.id.othersCombo);
        others.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ComboDetailActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
