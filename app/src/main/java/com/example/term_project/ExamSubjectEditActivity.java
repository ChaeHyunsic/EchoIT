package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
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
    TextView endAtText;
    DatePicker datePicker;
    Button button;
    String dt_str;
    int listIdx;
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
        datePicker = findViewById(R.id.date_picker_edit_js);
        button = findViewById(R.id.edit_btn_js);

        if(getIntent().hasExtra("title") && getIntent().hasExtra("content")){
            Log.d("INTENT", getIntent().getIntExtra("listIdx",0)+" "
                    +getIntent().getStringExtra("title")+" "
                    +getIntent().getStringExtra("content")+" "
                    +getIntent().getStringExtra("endAt"));
            listIdx = getIntent().getIntExtra("listIdx",0);
            title.setText(getIntent().getStringExtra("title"));
            content.setText(getIntent().getStringExtra("content"));
            endAtText.setText(getIntent().getStringExtra("endAt"));
        }
    }
    public PatchExamSubjectRequest getRequest(){
        String titleText = title.getText().toString();
        String contentText = content.getText().toString();
        Log.d("WHAT?", Date.valueOf(endAtText.getText().toString()).toString());
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
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                dt_str = String.format("%d-%02d-%02d",year,monthOfYear+1,dayOfMonth);
                endAtText.setText(dt_str);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refactorData();
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