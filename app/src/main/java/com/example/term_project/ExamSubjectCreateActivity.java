package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
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
import com.example.term_project.board.exam_board.request.PostExamSubjectRequest;
import com.example.term_project.board.exam_board.response.result.PostExamSubjectResult;
import com.example.term_project.view.PostExamSubjectView;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExamSubjectCreateActivity extends AppCompatActivity implements PostExamSubjectView {
    EditText titleEditTextView,contentEditTextView;
    Button button,date;
    String dt_str;
    Calendar calendar;
    ImageView close;
    DatePickerDialog datePickerDialog;

    private AlarmManager alarmManager;
    private GregorianCalendar mCalender;

    private NotificationManager notificationManager;
    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject_create);

        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        mCalender = new GregorianCalendar();
        setContentView(R.layout.activity_exam_subject_create);
        initView();
    }
    public void initView(){
        titleEditTextView = findViewById(R.id.exam_sub_title_et_js);
        contentEditTextView = findViewById(R.id.exam_sub_eval_et_js);
        date = findViewById(R.id.date_picker_btn_js);
        button = findViewById(R.id.register_btn_js);
        calendar = Calendar.getInstance();
        close = findViewById(R.id.exam_sub_close_iv_js);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        // 다이얼 로그 형식 지정 및 날짜 선택
        datePickerDialog = new DatePickerDialog(this,R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                dt_str = String.format("%d-%02d-%02d",year,month+1,dayOfMonth);
                date.setText(dt_str);
            }
        },mYear,mMonth,mDay);
        date.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if(date.isClickable()){
                    datePickerDialog.show();
                    datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(R.color.main_color);
                    datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(R.color.main_color);
                }
            }
        });
        // 일정 등록 닫기
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 일정 등록
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createData(); // 일정 추가 api 호출
            }
        });
    }

    public PostExamSubjectRequest getRequest(){
        String title = titleEditTextView.getText().toString();
        String content = contentEditTextView.getText().toString();
        Date endAt = Date.valueOf(dt_str);
        return new PostExamSubjectRequest(title,content,endAt);
    }
    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    // 일정 추가 API
    public void createData(){
        ExamSubjectService examSubjectService = new ExamSubjectService();
        examSubjectService.setPostExamSubjectView(this);
        examSubjectService.postExamSubject(getJwt(),getRequest()); // POST
    }

    // 일정 추가 성공 시
    @Override
    public void onPostExamSubjectSuccess(int code, PostExamSubjectResult result) {
        //AlarmReceiver에 값 전달
        Intent receiverIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, receiverIntent, PendingIntent.FLAG_IMMUTABLE);

        String from = result.getEndAt() + " 09:57:00"; //임의로 날짜와 시간을 지정
        //날짜 포맷을 바꿔주는 소스코드
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date datetime = null;
        try {
            datetime = dateFormat.parse(from);
            // datetime = (Date) dateFormat.parse(from);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar_3day = Calendar.getInstance();

        calendar_3day.setTime(datetime);
        calendar_3day.add(Calendar.DATE, -3);

        alarmManager.set(AlarmManager.RTC, calendar_3day.getTimeInMillis(),pendingIntent);

        Calendar calendar_7day = Calendar.getInstance();

        calendar_7day.setTime(datetime);
        calendar_7day.add(Calendar.DATE, -7);

        alarmManager.set(AlarmManager.RTC, calendar_7day.getTimeInMillis(),pendingIntent);

        finish();
    }

    @Override
    public void onPostExamSubjectFailure(int code, String message) {
        if(code == 2022){
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }
    }
}