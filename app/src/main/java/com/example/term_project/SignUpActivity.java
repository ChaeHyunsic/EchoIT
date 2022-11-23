package com.example.term_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.term_project.auth.AuthService;
import com.example.term_project.auth.request.User;
import com.example.term_project.view.SignUpView;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    private EditText signUpId,signUpPassword,passwordCheck,nickname;
    private Spinner department,grade;
    private AppCompatButton registerBtn;
    private TextView errorIdTextView;
    private TextView errorPwTextView;
    private TextView errorNicknameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }
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
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private User getUser(){
        String id = signUpId.getText().toString();
        String password = signUpPassword.getText().toString();
        String nickNameText = nickname.getText().toString();
        String departmentText = department.getSelectedItem().toString();
        int gradeText = Integer.parseInt(grade.getSelectedItem().toString());

        return new User(id,password,nickNameText,departmentText,gradeText);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void signUp(){
        if(signUpId.getText().toString().isEmpty()){
            Toast.makeText(this,"아이디를 입력해주세요.",Toast.LENGTH_SHORT).show();
            return;
        }
        if (!signUpPassword.getText().toString().equals(passwordCheck.getText().toString())){
            Toast.makeText(this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
            return;
        }

        AuthService authService = new AuthService();
        authService.setSignUpView(this);

        authService.signUp(getUser());
    }

    @Override
    public void onSignUpSuccess() {
        finish();
    }
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