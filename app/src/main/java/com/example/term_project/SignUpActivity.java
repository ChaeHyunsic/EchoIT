package com.example.term_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.term_project.auth.AuthService;
import com.example.term_project.auth.request.User;
import com.example.term_project.view.SignUpView;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    private TextInputEditText signUpId,signUpPassword,passwordCheck,nickname;
    private Spinner department,grade;
    private AppCompatButton registerBtn;
    private TextView errorIdTextView;
    private TextView errorPwTextView;
    private TextView errorNicknameTextView;
    private ImageView closeSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();

    }

    @Override
    protected void onResume() {
        super.onResume();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
        closeSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    // 뷰 초기화
    private void init(){
        signUpId = findViewById(R.id.sign_up_id_et_js);
        signUpPassword = findViewById(R.id.sign_up_password_et_js);
        passwordCheck = findViewById(R.id.sign_up_password_check_et_js);
        nickname = findViewById(R.id.sign_up_nickname_et_js);

        errorIdTextView = findViewById(R.id.sign_up_id_error_tv);
        errorPwTextView = findViewById(R.id.sign_up_password_error_tv);
        errorNicknameTextView = findViewById(R.id.sign_up_nickname_error_tv);

        department = findViewById(R.id.sign_up_department_sn_js);
        grade = findViewById(R.id.sign_up_grade_sn_js);
        registerBtn = findViewById(R.id.sign_up_register_cb_js);

        closeSignUp = findViewById(R.id.signup_close_iv_js);
    }

    // 입력값을 User Class에 담는 함수
    @RequiresApi(api = Build.VERSION_CODES.O)
    private User getUser(){
        String id = signUpId.getText().toString();
        String password = signUpPassword.getText().toString();
        String nickNameText = nickname.getText().toString();
        String departmentText = department.getSelectedItem().toString();
        int gradeText = Integer.parseInt(grade.getSelectedItem().toString());

        return new User(id,password,nickNameText,departmentText,gradeText);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    // 회원가입 API 호출 함수
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void signUp(){
        // 아이디 입력창이 비었을 때
        if(signUpId.getText().toString().isEmpty()){
            Toast.makeText(this,"아이디를 입력해주세요.",Toast.LENGTH_SHORT).show();
            return;
        }
        // 패스워드 불일치 예외
        if (!signUpPassword.getText().toString().equals(passwordCheck.getText().toString())){
            Toast.makeText(this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
            return;
        }
        // Retrofit -> API 호출
        AuthService authService = new AuthService();
        authService.setSignUpView(this);

        authService.signUp(getUser()); // 입력된 유저정보를 signUp 시킨다.
    }

    // 회원가입 성공시 -> 로그인 액티비티로 이동
    @Override
    public void onSignUpSuccess() {
        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    // 회원가입 실패시 -> 주로 정규식 or 유효성 예외처리
    @Override
    public void onSignUpFailure(int code) {
        switch (code){
            case 2018: // 아이디 중복
                errorIdTextView.setVisibility(View.VISIBLE);
                signUpId.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if(b){
                            errorIdTextView.setVisibility(View.GONE);
                        }
                    }
                });
                break;
            case 2011: // 비밀번호 정규식 예외
                errorPwTextView.setVisibility(View.VISIBLE);
                signUpPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if(b){
                            errorPwTextView.setVisibility(View.GONE);
                        }
                    }
                });
                break;
            case 2019: // 닉네임 중복
                errorNicknameTextView.setVisibility(View.VISIBLE);
                nickname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if(b){
                            errorNicknameTextView.setVisibility(View.GONE);
                        }
                    }
                });
                break;
        }
    }
}