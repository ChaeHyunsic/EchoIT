package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.term_project.board.exam_board.ExamSubjectService;
import com.example.term_project.board.exam_board.response.result.GetExamSubjectsResult;
import com.example.term_project.view.GetExamSubjectsView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ExamSubjectActivity extends AppCompatActivity implements GetExamSubjectsView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject);


        FloatingActionButton floatingActionButton = findViewById(R.id.plus_item_fab_js);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExamSubjectActivity.this,ExamSubjectEditActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getList();
    }

    private void initRecyclerView(ArrayList<GetExamSubjectsResult> result){
        RecyclerView recyclerView = findViewById(R.id.exam_sub_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ExamSubjectAdapter adapter = new ExamSubjectAdapter(result);
        recyclerView.setAdapter(adapter);
    }
    private void getList(){
        ExamSubjectService examSubjectService = new ExamSubjectService();
        examSubjectService.setGetExamSubjectsView(this);

        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        String token = spf.getString("jwt","");
        Log.d("JWT",token);
        examSubjectService.getExamSubjects(token);
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