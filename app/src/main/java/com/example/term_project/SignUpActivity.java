package com.example.term_project;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.term_project.model.UserModel;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    private EditText signUpId,signUpPassword,passwordCheck,nickname;
    private Spinner department,grade;
    private AppCompatButton registerBtn;

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
                finish();
            }
        });
    }
    private void init(){
        signUpId = findViewById(R.id.sign_up_id_et_js);
        signUpPassword = findViewById(R.id.sign_up_password_et_js);
        passwordCheck = findViewById(R.id.sign_up_password_check_et_js);
        nickname = findViewById(R.id.sign_up_nickname_et_js);

        department = findViewById(R.id.sign_up_department_sn_js);
        grade = findViewById(R.id.sign_up_grade_sn_js);
        registerBtn = findViewById(R.id.sign_up_register_cb_js);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private UserModel getUser(){
        String id = signUpId.getText().toString();
        String password = signUpPassword.getText().toString();
        String nickNameText = nickname.getText().toString();
        String departmentText = department.getSelectedItem().toString();
        int gradeText = Integer.parseInt(grade.getSelectedItem().toString());
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return new UserModel(id,password,nickNameText,departmentText,gradeText,dateTime.format(formatter),dateTime.format(formatter),"A");
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
        final AppDatabase DB = AppDatabase.getInstance(this);
        final List<UserModel> users = DB.userDao().getUsers(); // 로그 출력용
        DB.userDao().insert(getUser());
        Log.d("Input",getUser().getUserID()+" "+getUser().getPassword()+" "+getUser().getNickname()+" "+getUser().getDepartment()+" "+getUser().getGrade()+" "+getUser().getStatus());
        Log.d("User",users.toString());
    }
}