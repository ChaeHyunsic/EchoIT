package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.term_project.model.UserModel;

public class LoginActivity extends AppCompatActivity {

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
    private void login(){
        if(loginId.getText().toString().isEmpty()){
            Toast.makeText(this,"아이디를 입력해주세요.",Toast.LENGTH_SHORT).show();
            return;
        }
        if (loginPassword.getText().toString().isEmpty()){
            Toast.makeText(this,"비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show();
            return;
        }
        String id = loginId.getText().toString();
        String password = loginPassword.getText().toString();
        final AppDatabase DB = AppDatabase.getInstance(this);
        final UserModel user = DB.userDao().getUser(id,password);
        if(user != null){
            Log.d("Login_Info","userId : "+user.getUserID() + " pw : "+ user.getPassword());
            saveId(user.getId());
            startMainActivity();
        }else{
            Toast.makeText(this,"회원 정보가 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
        }
    }
    // User의 고유PK id를 Sharedpreference에 저장하는 함수
    private void saveId(Long id){
        final SharedPreferences spf = getSharedPreferences("auth",MODE_PRIVATE);
        final SharedPreferences.Editor editor = spf.edit();
        editor.putLong("token",id);
        editor.apply();
    }

    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}