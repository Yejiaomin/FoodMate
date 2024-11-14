package com.example.owner;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        Button addMenuButton = findViewById(R.id.addMenuButton);
        addMenuButton.setOnClickListener(v -> {
            // 添加菜单项逻辑
        });
    }
}
