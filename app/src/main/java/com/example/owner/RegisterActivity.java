package com.example.owner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button registerButton = findViewById(R.id.registerSubmitButton);
        CheckBox userTypeCheckBox = findViewById(R.id.toggleUserTypeButton); // 选择用户类型的 CheckBox


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (email.isEmpty() || password.isEmpty() ) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (userTypeCheckBox.isChecked()) {
                        Restaurant restaurant = new Restaurant(email, password,"RestaurantName", "123456789", "10:00 AM - 9:00 PM");
                        RestaurantApiService restaurantApi = RetrofitClient.getRetrofitInstance().create(RestaurantApiService.class);
                        restaurantApi.registerRestaurant(restaurant).enqueue(new Callback<RestaurantResponse>() {
                            @Override
                            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Restaurant registered successfully", Toast.LENGTH_SHORT).show();
                                    navigateToRestaurantActivity();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Restaurant registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                                Toast.makeText(RegisterActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        User user = new User(email, password);
                        UserApiService userApi = RetrofitClient.getRetrofitInstance().create(UserApiService.class);
                        userApi.registerUser(user).enqueue(new Callback<UserResponse>() {
                            @Override
                            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                Log.v("Response-------", response.toString());
                                if (response.isSuccessful()) {

                                    Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                    navigateToUserActivity();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "User registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<UserResponse> call, Throwable t) {
                                Toast.makeText(RegisterActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                }
            }
        });
    }
    private void navigateToRestaurantActivity() {
        Intent intent = new Intent(RegisterActivity.this, RestaurantActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToUserActivity() {
        Intent intent = new Intent(RegisterActivity.this, UserActivity.class);
        startActivity(intent);
        finish();
    }
}
