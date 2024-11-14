package com.example.owner;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class RestaurantActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        tabLayout = findViewById(R.id.tabLayout);
        frameLayout = findViewById(R.id.frameLayout);

        // 添加Tab选项
        tabLayout.addTab(tabLayout.newTab().setText("Combo"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu"));
        tabLayout.addTab(tabLayout.newTab().setText("Review"));

        // 默认显示 ComboFragment
        loadFragment(new ComboFragment());

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment selectedFragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        selectedFragment = new ComboFragment();
                        break;
                    case 1:
                        selectedFragment = new MenuFragment();
                        break;
                    case 2:
                        selectedFragment = new ReviewFragment();
                        break;
                }
                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}
