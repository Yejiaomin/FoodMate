package com.example.owner;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_detail);
        // 仅显示详细评论
    }
}
