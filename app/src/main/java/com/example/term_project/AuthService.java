package com.example.term_project;

import static com.example.term_project.NetworkModule.getRetrofit;

import android.util.Log;
import android.widget.Toast;

import com.example.term_project.model.User;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthService {
    private SignUpView signUpView;

    void setSignUpView(SignUpView signUpView){
        this.signUpView=signUpView;
    }

    void signUp(User user){
        AuthRetrofitInterface authService = getRetrofit().create(AuthRetrofitInterface.class);
        authService.signUp(user).enqueue(new Callback<AuthResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                Log.d("SIGNUP/SUCCESS", response.toString());
                AuthResponse resp =  response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    signUpView.OnSignUpSuccess();
                }else{
                    signUpView.OnSignUpFailure(resp.getCode());
                }
            }

            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.d("SIGNUP/FAIL", t.getMessage());
            }
        });
        Log.d("SIGNUP","HELLO");
    }
}
