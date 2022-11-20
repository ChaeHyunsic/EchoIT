package com.example.term_project.view;

import com.example.term_project.auth.ResultLogin;

public interface LoginView {
    void onLoginSuccess(int code, ResultLogin result);
    void onLoginFailure(int code);
}
