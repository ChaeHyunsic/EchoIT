package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText loginId;
    private EditText loginPassword;
    private AppCompatButton loginButton, registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginId = findViewById(R.id.login_id_et_js);
        loginPassword = findViewById(R.id.login_password_et_js);
        loginButton = findViewById(R.id.login_button_gy);
        registerButton = findViewById(R.id.regiest_button_gy);


        // 회원가입 버튼 액티비티 이동
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });


    }
}