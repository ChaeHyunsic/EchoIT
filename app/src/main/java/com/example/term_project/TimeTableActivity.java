package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.term_project.board.course.CourseService;
import com.example.term_project.board.course.response.result.GetTimeTableListResult;
import com.example.term_project.view.GetTimeTableView;

import java.util.ArrayList;

public class TimeTableActivity extends AppCompatActivity implements GetTimeTableView {
    ImageView courseList,myCourseList;
    TextView monday[] = new TextView[12];
    TextView tuesday[] = new TextView[12];
    TextView wednesday[] = new TextView[12];
    TextView thursday[] = new TextView[12];
    TextView friday[] = new TextView[12];
    TimeTable timeTable = new TimeTable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        initView();
        initTextViewList();
    }
    private void initView(){
        courseList = findViewById(R.id.course_list_iv_js);
        myCourseList = findViewById(R.id.my_course_list_iv_js);
    }
    private void initTextViewList(){
        monday[0] = findViewById(R.id.monday0);
        monday[1] = findViewById(R.id.monday1);
        monday[2] = findViewById(R.id.monday2);
        monday[3] = findViewById(R.id.monday3);
        monday[4] = findViewById(R.id.monday4);
        monday[5] = findViewById(R.id.monday5);
        monday[6] = findViewById(R.id.monday6);
        monday[7] = findViewById(R.id.monday7);
        monday[8] = findViewById(R.id.monday8);
        monday[9] = findViewById(R.id.monday9);
        monday[10] = findViewById(R.id.monday10);
        monday[11] = findViewById(R.id.monday11);

        tuesday[0] = findViewById(R.id.tuesday0);
        tuesday[1] = findViewById(R.id.tuesday1);
        tuesday[2] = findViewById(R.id.tuesday2);
        tuesday[3] = findViewById(R.id.tuesday3);
        tuesday[4] = findViewById(R.id.tuesday4);
        tuesday[5] = findViewById(R.id.tuesday5);
        tuesday[6] = findViewById(R.id.tuesday6);
        tuesday[7] = findViewById(R.id.tuesday7);
        tuesday[8] = findViewById(R.id.tuesday8);
        tuesday[9] = findViewById(R.id.tuesday9);
        tuesday[10] = findViewById(R.id.tuesday10);
        tuesday[11] = findViewById(R.id.tuesday11);

        wednesday[0] = findViewById(R.id.wednesday0);
        wednesday[1] = findViewById(R.id.wednesday1);
        wednesday[2] = findViewById(R.id.wednesday2);
        wednesday[3] = findViewById(R.id.wednesday3);
        wednesday[4] = findViewById(R.id.wednesday4);
        wednesday[5] = findViewById(R.id.wednesday5);
        wednesday[6] = findViewById(R.id.wednesday6);
        wednesday[7] = findViewById(R.id.wednesday7);
        wednesday[8] = findViewById(R.id.wednesday8);
        wednesday[9] = findViewById(R.id.wednesday9);
        wednesday[10] = findViewById(R.id.wednesday10);
        wednesday[11] = findViewById(R.id.wednesday11);

        thursday[0] = findViewById(R.id.thursday0);
        thursday[1] = findViewById(R.id.thursday1);
        thursday[2] = findViewById(R.id.thursday2);
        thursday[3] = findViewById(R.id.thursday3);
        thursday[4] = findViewById(R.id.thursday4);
        thursday[5] = findViewById(R.id.thursday5);
        thursday[6] = findViewById(R.id.thursday6);
        thursday[7] = findViewById(R.id.thursday7);
        thursday[8] = findViewById(R.id.thursday8);
        thursday[9] = findViewById(R.id.thursday9);
        thursday[10] = findViewById(R.id.thursday10);
        thursday[11] = findViewById(R.id.thursday11);

        friday[0] = findViewById(R.id.friday0);
        friday[1] = findViewById(R.id.friday1);
        friday[2] = findViewById(R.id.friday2);
        friday[3] = findViewById(R.id.friday3);
        friday[4] = findViewById(R.id.friday4);
        friday[5] = findViewById(R.id.friday5);
        friday[6] = findViewById(R.id.friday6);
        friday[7] = findViewById(R.id.friday7);
        friday[8] = findViewById(R.id.friday8);
        friday[9] = findViewById(R.id.friday9);
        friday[10] = findViewById(R.id.friday10);
        friday[11] = findViewById(R.id.friday11);
    }


    @Override
    protected void onResume() {
        super.onResume();
        getTimeTableList();
        courseList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeTableActivity.this,CourseListActivity.class);
                startActivity(intent);
            }
        });
        myCourseList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeTableActivity.this,MyCourseListActivity.class);
                startActivity(intent);
            }
        });
    }

    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    private void getTimeTableList(){
        CourseService courseService = new CourseService();
        courseService.setGetTimeTableView(this);

        courseService.getTimeTable(getJwt());
    }

    @Override
    public void onGetTimeTableSuccess(int code, ArrayList<GetTimeTableListResult> result) {
        for(int i=0;i<result.size();i++){
            timeTable.addTimeTable(result.get(i).getTime(),result.get(i).getSubjectName(),result.get(i).getRoom());
        }
        timeTable.settingTimeTable(monday,tuesday,wednesday,thursday,friday,this);
    }

    @Override
    public void onGetTimeTableFailure(int code, String message) {

    }
}