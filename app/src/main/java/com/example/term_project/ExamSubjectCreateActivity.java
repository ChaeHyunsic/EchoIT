package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.example.term_project.board.exam_board.request.PostExamSubjectRequest;
import com.example.term_project.view.PostExamSubjectView;

import java.sql.Date;
import java.util.Calendar;

public class ExamSubjectCreateActivity extends AppCompatActivity implements PostExamSubjectView {
    EditText titleEditTextView,contentEditTextView;
    TextView endAtTextView;
    DatePicker datePicker;
    Button button;
    String dt_str;
    ExamSubjectAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject_create);
        initView();
    }
    public void initView(){
        titleEditTextView = findViewById(R.id.title_et_create_js);
        contentEditTextView = findViewById(R.id.content_et_create_js);
        endAtTextView = findViewById(R.id.deadline_check_tv_js);
        datePicker = findViewById(R.id.date_picker_js);
        button = findViewById(R.id.register_btn_js);
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
                endAtTextView.setText(dt_str);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createData();
            }
        });
    }

    public PostExamSubjectRequest getRequest(){
        String title = titleEditTextView.getText().toString();
        String content = contentEditTextView.getText().toString();
        Log.d("WHAT?",Date.valueOf(endAtTextView.getText().toString()).toString());
        Date endAt = Date.valueOf(dt_str);
        return new PostExamSubjectRequest(title,content,endAt);
    }
    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    public void createData(){
        ExamSubjectService examSubjectService = new ExamSubjectService();
        examSubjectService.setPostExamSubjectView(this);
        examSubjectService.postExamSubject(getJwt(),getRequest());
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onPostExamSubjectSuccess() {
        adapter.notifyDataSetChanged();
        finish();
    }

    @Override
    public void onPostExamSubjectFailure(int code, String message) {
        if(code == 2022){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }
    }
}