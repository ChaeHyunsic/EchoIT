package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.term_project.board.evaluate_board.EvaluateSubjectService;
import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;
import com.example.term_project.board.evaluate_board.response.result.GetSubjectInfoResult;
import com.example.term_project.board.evaluate_board.response.result.GetSubjectReviewsResult;
import com.example.term_project.view.GetSubjectInfoView;
import com.example.term_project.view.GetSubjectReviewsView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class SubjectInfoActivity extends AppCompatActivity implements GetSubjectReviewsView {
    RecyclerView recyclerView;
    EvaluateReviewAdapter adapter;
    TextView subjectName,professor,scoreText,grade,time,room,credit;
    ImageView imageView;
    RatingBar ratingBarInficator;
    ExtendedFloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_info);
        initView();
    }
    private void initView(){
        subjectName = findViewById(R.id.selected_subject_tv_name);

        professor = findViewById(R.id.selected_subject_professor_name_data_js);
        grade=findViewById(R.id.selected_subject_grade_tv_data_js);
        time=findViewById(R.id.selected_subject_time_tv_data_js);
        room=findViewById(R.id.selected_subject_room_tv_data_js);
        credit=findViewById(R.id.selected_subject_credit_tv_data_js);

        scoreText = findViewById(R.id.subject_score_average_tv_js);
        ratingBarInficator = findViewById(R.id.ratingBarInficator);

        imageView = findViewById(R.id.subject_info_close_iv_js);
        button = findViewById(R.id.evaluate_subject_fab_js);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (getIntent().hasExtra("subjectIdx") && getIntent().hasExtra("subjectName") && getIntent().hasExtra("professor")) {
            subjectName.setText(getIntent().getStringExtra("subjectName")); // 과목명
            professor.setText(getIntent().getStringExtra("professor")); // 교수명
            grade.setText(String.valueOf(getIntent().getIntExtra("grade",0))); // 학년
            time.setText(getIntent().getStringExtra("time")); // 강의시간
            room.setText(getIntent().getStringExtra("room")); // 강의실
            credit.setText(String.valueOf(getIntent().getIntExtra("credit",0))); // 학점
            scoreText.setText(String.valueOf(getIntent().getFloatExtra("scoreAverage",0))); // 강의평점
            ratingBarInficator.setRating(getIntent().getFloatExtra("scoreAverage",0)); // 강의평점

            getList(getIntent().getIntExtra("subjectIdx",0)); // 강의리뷰목록 조회 api 호출
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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

    // 리사이클러뷰 초기화
    private void initRecyclerView(ArrayList<GetSubjectReviewsResult> result){
        recyclerView = findViewById(R.id.evaluate_review);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EvaluateReviewAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    // 강의리뷰목록 조회 api
    private void getList(int subjectIdx){
        EvaluateSubjectService evaluateSubjectService = new EvaluateSubjectService();
        evaluateSubjectService.setGetSubjectReviewsView(this);

        evaluateSubjectService.getSubjectReviews(subjectIdx); // GET
    }
    // 과목정보 하단 후기목록
    @Override
    public void onGetSubjectReviewsSuccess(int code, ArrayList<GetSubjectReviewsResult> result) {
        initRecyclerView(result);
    }

    @Override
    public void onGetSubjectReviewsFailure(int code, String message) {

    }

}