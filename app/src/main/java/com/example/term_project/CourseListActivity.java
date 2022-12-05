package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.term_project.board.course.CourseService;
import com.example.term_project.board.course.response.result.GetCourseListResult;
import com.example.term_project.board.evaluate_board.EvaluateSubjectService;
import com.example.term_project.view.GetCoursesView;

import java.util.ArrayList;

public class CourseListActivity extends AppCompatActivity implements GetCoursesView {
    Spinner courseGrade;
    AppCompatButton button;
    RecyclerView recyclerView;
    CourseListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        initView();
    }
    private void initView(){
        courseGrade = findViewById(R.id.spinners);
        button = findViewById(R.id.complete_btn_js);
    }
    private void initRecyclerView(ArrayList<GetCourseListResult> result){
        recyclerView = findViewById(R.id.course_list_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CourseListAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    private void getList(Integer grade){
        CourseService courseService = new CourseService();
        courseService.setGetCoursesView(this);

        courseService.getCourses(grade);
    }

    @Override
    protected void onResume() {
        super.onResume();
        courseGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(courseGrade.getSelectedItem().toString().equals("전체")){
                    Log.d("INPUT-SPINNER :",courseGrade.getSelectedItem().toString());
                    getList(null);
                }else{
                    Log.d("INPUT-SPINNER-NUM :",courseGrade.getSelectedItem().toString());
                    getList(Integer.parseInt(courseGrade.getSelectedItem().toString()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                getList(null);
            }
        });
    }

    @Override
    public void onGetCoursesSuccess(int code, ArrayList<GetCourseListResult> result) {
        initRecyclerView(result);
    }

    @Override
    public void onGetCoursesFailure(int code, String message) {

    }
}