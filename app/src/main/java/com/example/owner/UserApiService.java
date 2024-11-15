package com.example.owner;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApiService {
    @POST("api/users/register")
    Call<UserResponse> registerUser(@Body User user);

    @POST("api/users/login") // 确保路径与后端一致
    Call<UserResponse> loginUser(@Body LoginRequest loginRequest);

    @GET("api/users") // 确保路径与后端一致
    Call<UserResponse> getUsers();

}
