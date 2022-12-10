package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.term_project.board.exam_board.ExamSubjectService;
import com.example.term_project.board.exam_board.response.result.GetExamSubjectsResult;
import com.example.term_project.view.DeleteExamSubjectView;
import com.example.term_project.view.GetExamSubjectsView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ExamSubjectActivity extends AppCompatActivity implements GetExamSubjectsView{
    ExamSubjectAdapter adapter;
    RecyclerView recyclerView;
    ImageView close;
    ExtendedFloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject);
        initView();
    }
    private void initView(){
        floatingActionButton = findViewById(R.id.exam_sub_plus_fab_js);
        close = findViewById(R.id.exam_sub_close_iv_js);
    }
    @Override
    protected void onStart() {
        super.onStart();
        getList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExamSubjectActivity.this, ExamSubjectCreateActivity.class);
                startActivity(intent);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initRecyclerView(ArrayList<GetExamSubjectsResult> result){
        recyclerView = findViewById(R.id.exam_sub_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ExamSubjectAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    private void getList(){
        ExamSubjectService examSubjectService = new ExamSubjectService();
        examSubjectService.setGetExamSubjectsView(this);

        examSubjectService.getExamSubjects(getJwt());
    }


    @Override
    public void onGetExamSubjectSuccess(int code, ArrayList<GetExamSubjectsResult> result) {
        initRecyclerView(result);
    }

    @Override
    public void onGetExamSubjectFailure(int code, String message) {
        Log.d("GET-EXAM-SUBJECT",message);
    }
}