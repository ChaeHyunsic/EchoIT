package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.term_project.board.evaluate_board.EvaluateSubjectService;
import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;
import com.example.term_project.board.evaluate_board.response.result.GetSubjectInfoResult;
import com.example.term_project.board.evaluate_board.response.result.GetSubjectReviewsResult;
import com.example.term_project.view.GetSubjectInfoView;
import com.example.term_project.view.GetSubjectReviewsView;

import java.util.ArrayList;

public class SubjectInfoActivity extends AppCompatActivity implements GetSubjectReviewsView, GetSubjectInfoView {
    RecyclerView recyclerView;
    EvaluateReviewAdapter adapter;
    TextView subjectName,professor,score;
    RatingBar ratingBarInficator;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_info);
        initView();
    }
    private void initView(){
        subjectName = findViewById(R.id.selected_subject_tv_name);
        professor = findViewById(R.id.professor_name_tv_js);
        score = findViewById(R.id.subject_score_tv_js);
        ratingBarInficator = findViewById(R.id.ratingBarInficator);
        button = findViewById(R.id.go_to_evaluate);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (getIntent().hasExtra("subjectIdx") && getIntent().hasExtra("subjectName") && getIntent().hasExtra("professor")) {
            Log.d("INTENT", getIntent().getIntExtra("subjectIdx",0)+" "
                    +getIntent().getStringExtra("subjectName")+" "
                    +getIntent().getStringExtra("professor"));
            subjectName.setText(getIntent().getStringExtra("subjectName"));
            professor.setText(getIntent().getStringExtra("professor"));
            getSubjectInfo(getIntent().getIntExtra("subjectIdx",0));
            getList(getIntent().getIntExtra("subjectIdx",0));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubjectInfoActivity.this,EvaluateActivity.class);
                intent.putExtra("subjectIdx",getIntent().getIntExtra("subjectIdx",0));
                intent.putExtra("subjectName",subjectName.getText());
                intent.putExtra("professor",professor.getText());
                startActivity(intent);
            }
        });
    }

    private void getSubjectInfo(int subjectIdx){
        EvaluateSubjectService evaluateSubjectService = new EvaluateSubjectService();
        evaluateSubjectService.setGetSubjectInfoView(this);

        evaluateSubjectService.getSubjectInfo(subjectIdx);
    }

    private void initRecyclerView(ArrayList<GetSubjectReviewsResult> result){
        recyclerView = findViewById(R.id.evaluate_review);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EvaluateReviewAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    private void getList(int subjectIdx){
        EvaluateSubjectService evaluateSubjectService = new EvaluateSubjectService();
        evaluateSubjectService.setGetSubjectReviewsView(this);

        evaluateSubjectService.getSubjectReviews(subjectIdx);
    }
    // 과목정보 하단 후기목록
    @Override
    public void onGetSubjectReviewsSuccess(int code, ArrayList<GetSubjectReviewsResult> result) {
        initRecyclerView(result);
    }

    @Override
    public void onGetSubjectReviewsFailure(int code, String message) {

    }

    // 과목정보 상단
    @Override
    public void onGetSubjectInfoSuccess(int code, GetSubjectInfoResult result) {
        Log.d("WHY2", String.valueOf(result.getScoreAverage()));
        score.setText(String.valueOf(result.getScoreAverage()));
        ratingBarInficator.setRating(result.getScoreAverage());
    }

    @Override
    public void onGetSubjectInfoFailure(int code, String message) {

    }
}