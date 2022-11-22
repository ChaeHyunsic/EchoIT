package com.example.term_project.view;

import com.example.term_project.auth.response.result.LoginResult;

public interface LoginView {
    void onLoginSuccess(int code, LoginResult result);
    void onLoginFailure(int code);
}
