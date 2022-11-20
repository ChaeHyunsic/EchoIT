package com.example.term_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.term_project.auth.AuthService;
import com.example.term_project.auth.ResultLogin;
import com.example.term_project.model.User;
import com.example.term_project.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText loginId;
    private EditText loginPassword;
    private AppCompatButton loginButton, registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        // 회원가입 버튼 액티비티 이동
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                login();
                finish();
            }
        });
    }
    private void init(){
        loginId = findViewById(R.id.login_id_et_js);
        loginPassword = findViewById(R.id.login_password_et_js);
        loginButton = findViewById(R.id.login_button_gy);
        registerButton = findViewById(R.id.regiest_button_gy);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private User getUser(){
        String id = loginId.getText().toString();
        String password = loginPassword.getText().toString();

        return new User(id,password);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void login(){
        if(loginId.getText().toString().isEmpty()){
            Toast.makeText(this,"아이디를 입력해주세요.",Toast.LENGTH_SHORT).show();
            return;
        }
        if (loginPassword.getText().toString().isEmpty()){
            Toast.makeText(this,"비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show();
            return;
        }

        AuthService authService = new AuthService();
        authService.setLoginView(this);

        authService.login(getUser());
    }

    // User의 고유PK id를 Sharedpreference에 저장하는 함수
    private void saveJwt(String jwt){
        final SharedPreferences spf = getSharedPreferences("auth",MODE_PRIVATE);
        final SharedPreferences.Editor editor = spf.edit();

        editor.putString("jwt",jwt);
        editor.apply();
    }

    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginSuccess(int code, ResultLogin result) {
        if(code == 1000){
            saveJwt(result.getJwt());
            startMainActivity();
        }
    }

    @Override
    public void onLoginFailure(int code) {

    }
}