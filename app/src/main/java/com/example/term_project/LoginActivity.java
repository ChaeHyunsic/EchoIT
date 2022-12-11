package com.example.term_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.term_project.auth.AuthService;
import com.example.term_project.auth.response.result.LoginResult;
import com.example.term_project.auth.request.User;
import com.example.term_project.view.LoginView;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private TextInputEditText loginId;
    private TextInputEditText loginPassword;
    private AppCompatButton loginButton, registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 회원가입 버튼 -> 회원가입 액티비티 이동
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        // 로그인 버튼 -> 메인 액티비티 이동
        loginButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    // 화면이 완전히 가려졌을 때 호출
    // onStop()에서 호출을 하면 MainActivity의 렌더링 후 액티비티가 Destroy될 수 있다.
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    // 뷰 초기화
    private void init(){
        loginId = findViewById(R.id.login_id_et_js);
        loginPassword = findViewById(R.id.login_password_et_js);
        loginButton = findViewById(R.id.login_button_gy);
        registerButton = findViewById(R.id.regiest_button_gy);
    }

    // 입력한 정보 가져오기
    @RequiresApi(api = Build.VERSION_CODES.O)
    private User getUser(){
        String id = loginId.getText().toString();
        String password = loginPassword.getText().toString();

        return new User(id,password);
    }

    // 로그인 API 호출
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
    private void saveJwt(String jwt, int grade, String nickName, String department){
        final SharedPreferences spf = getSharedPreferences("auth",MODE_PRIVATE);
        final SharedPreferences.Editor editor = spf.edit();
        editor.putInt("grade",grade);
        editor.putString("jwt",jwt);
        editor.putString("nickName",nickName);
        editor.putString("department",department);
        editor.apply();
    }

    // 메인 액티비티로 이동
    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    // 로그인에 성공했을 때
    @Override
    public void onLoginSuccess(int code, LoginResult result) {
        if(code == 1000){
            saveJwt(result.getJwt(),result.getGrade(),result.getNickName(),result.getDepartment()); // 1. SharedPreference에 jwt token 저장 + grade 저장
            startMainActivity(); // 2. 메인 액티비티로의 이동
        }
    }

    // 귀찮아서.. 원래 정규식 or 유효성 처리에 관한 코드 분기로 토스트 띄워주는게 좋음
    @Override
    public void onLoginFailure(int code) {

    }
}