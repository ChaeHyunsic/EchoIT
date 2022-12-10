package com.example.term_project.auth;

import static com.example.term_project.network.NetworkModule.getRetrofit;

import android.util.Log;

import com.example.term_project.auth.request.User;
import com.example.term_project.auth.response.AuthResponse;
import com.example.term_project.view.LoginView;
import com.example.term_project.view.SignUpView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthService {
    private SignUpView signUpView;
    private LoginView loginView;

    public void setSignUpView(SignUpView signUpView){
        this.signUpView=signUpView;
    }
    public void setLoginView(LoginView loginView){
        this.loginView=loginView;
    }

    public void signUp(User user){
        AuthRetrofitInterface authService = getRetrofit().create(AuthRetrofitInterface.class);
        authService.signUp(user).enqueue(new Callback<AuthResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                Log.d("SIGNUP/SUCCESS", response.toString());
                AuthResponse resp =  response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    signUpView.onSignUpSuccess();
                }else{
                    signUpView.onSignUpFailure(resp.getCode());
                }
            }

            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.d("SIGNUP/FAIL", t.getMessage());
            }
        });
        Log.d("SIGNUP","HELLO");
    }

    public void login(User user){
        AuthRetrofitInterface authService = getRetrofit().create(AuthRetrofitInterface.class);
        authService.login(user).enqueue(new Callback<AuthResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                Log.d("LOGIN/SUCCESS", response.toString());
                AuthResponse resp =  response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    loginView.onLoginSuccess(resp.getCode(),resp.getResult());
                }else{
                    loginView.onLoginFailure(resp.getCode());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.d("LOGIN/FAIL", t.getMessage());
            }
        });
        Log.d("LOGIN","HELLO");
    }
}
