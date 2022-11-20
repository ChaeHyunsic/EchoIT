package com.example.term_project.auth;

import com.example.term_project.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthRetrofitInterface {
    @POST("/app/users")
    Call<AuthResponse> signUp(@Body User user);

    @POST("/app/users/login")
    Call<AuthResponse> login(@Body User user);
}
