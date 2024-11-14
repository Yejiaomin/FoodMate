package com.example.owner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ComboDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo_detail);

        Button addComboButton = findViewById(R.id.addComboButton);
        addComboButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 添加逻辑
                Toast.makeText(ComboDetailActivity.this, "Add Combo Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}