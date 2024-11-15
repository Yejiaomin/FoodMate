package com.example.owner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button loginButton = findViewById(R.id.loginSubmitButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Restaurant restaurant = new Restaurant();
                    restaurant.setEmail(email);
                    restaurant.setPassword(password);

                    RestaurantApiService restaurantApiService = RetrofitClient.getRetrofitInstance().create(RestaurantApiService.class);
                    restaurantApiService.loginRestaurant(restaurant).enqueue(new Callback<RestaurantResponse>(){

                        @Override
                        public void onResponse(@NonNull Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                String userType = response.body().getUserType();

                                if (userType.equals("User")) {
                                    Intent intent = new Intent(LoginActivity.this, UserActivity.class);
                                    startActivity(intent);
                                } else if (userType.equals("Restaurant")) {
                                    Intent intent = new Intent(LoginActivity.this, RestaurantActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}
