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
        getList(); // api 호출
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 일정 추가 버튼 클릭
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExamSubjectActivity.this, ExamSubjectCreateActivity.class);
                startActivity(intent);
            }
        });
        // 시험 / 과제 게시판 닫기
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // 리사이클러뷰 초기화
    private void initRecyclerView(ArrayList<GetExamSubjectsResult> result){
        recyclerView = findViewById(R.id.exam_sub_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ExamSubjectAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    // jwt 토큰 get
    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }

    // 시험 / 과제 게시판 API 호출 함수
    private void getList(){
        ExamSubjectService examSubjectService = new ExamSubjectService();
        examSubjectService.setGetExamSubjectsView(this);

        examSubjectService.getExamSubjects(getJwt()); // 유저 당 일정 목록 Get
    }

    // 시험 / 과제 게시판 API 호출 성공 시
    @Override
    public void onGetExamSubjectSuccess(int code, ArrayList<GetExamSubjectsResult> result) {
        initRecyclerView(result);
    }

    @Override
    public void onGetExamSubjectFailure(int code, String message) {
    }
}