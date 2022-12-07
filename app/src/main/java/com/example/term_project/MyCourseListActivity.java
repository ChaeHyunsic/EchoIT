package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.term_project.board.course.CourseService;
import com.example.term_project.board.course.response.result.GetCourseListResult;
import com.example.term_project.board.course.response.result.GetTimeTableListResult;
import com.example.term_project.view.GetTimeTableView;

import java.util.ArrayList;

public class MyCourseListActivity extends AppCompatActivity implements GetTimeTableView {
    RecyclerView recyclerView;
    MyCourseListAdapter adapter;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_course_list);
        initView();
    }
    private void initView(){
        imageView = findViewById(R.id.my_course_list_close_iv_js);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getTimeTableList();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCourseListActivity.this,TimeTableActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void initRecyclerView(ArrayList<GetTimeTableListResult> result){
        recyclerView = findViewById(R.id.my_course_list_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyCourseListAdapter(result,this);
        recyclerView.setAdapter(adapter);
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
        initRecyclerView(result);
    }

    @Override
    public void onGetTimeTableFailure(int code, String message) {

    }
}