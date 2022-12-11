package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.term_project.board.exam_board.ExamSubjectService;
import com.example.term_project.board.exam_board.request.PatchExamSubjectRequest;
import com.example.term_project.board.exam_board.request.PostExamSubjectRequest;
import com.example.term_project.view.PatchExamSubjectView;

import java.sql.Date;
import java.util.Calendar;

public class ExamSubjectEditActivity extends AppCompatActivity implements PatchExamSubjectView {
    EditText title,content;
    Button endAtText;
    DatePicker datePicker;
    Button button;
    Calendar calendar;
    String dt_str;
    int listIdx;
    ImageView close;
    DatePickerDialog datePickerDialog;
    ExamSubjectAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject_edit);
        initView();
    }
    private void initView(){
        title = findViewById(R.id.title_et_js);
        content = findViewById(R.id.content_et_js);
        endAtText = findViewById(R.id.deadline_check_tv_edit_js);
        button = findViewById(R.id.edit_btn_js);
        calendar = Calendar.getInstance();
        close = findViewById(R.id.exam_sub_close_iv_js);

        if(getIntent().hasExtra("title") && getIntent().hasExtra("content")){
            listIdx = getIntent().getIntExtra("listIdx",0);
            title.setText(getIntent().getStringExtra("title"));
            content.setText(getIntent().getStringExtra("content"));
            endAtText.setText(getIntent().getStringExtra("endAt"));
        }
    }
    public PatchExamSubjectRequest getRequest(){
        String titleText = title.getText().toString();
        String contentText = content.getText().toString();
        Date endAt = Date.valueOf(endAtText.getText().toString());
        return new PatchExamSubjectRequest(titleText,contentText,endAt);
    }
    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    public void refactorData(){
        ExamSubjectService examSubjectService = new ExamSubjectService();
        examSubjectService.setPatchExamSubjectView(this);
        examSubjectService.patchExamSubject(getJwt(),listIdx,getRequest());
    }
    @Override
    protected void onResume() {
        super.onResume();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(this,R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                dt_str = String.format("%d-%02d-%02d",year,month+1,dayOfMonth);
                endAtText.setText(dt_str);
            }
        },mYear,mMonth,mDay);
        endAtText.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if(endAtText.isClickable()){
                    datePickerDialog.show();
                    datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(R.color.main_color);
                    datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(R.color.main_color);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refactorData();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    @Override
    public void onPatchExamSubjectSuccess() {
        finish();
    }

    @Override
    public void onPatchExamSubjectFailure(int code, String message) {
        if(code == 2023){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }
    }
}