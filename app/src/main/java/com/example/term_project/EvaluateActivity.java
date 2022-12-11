package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.term_project.board.evaluate_board.EvaluateSubjectService;
import com.example.term_project.board.evaluate_board.request.PostEvaluateSubjectReviewRequest;
import com.example.term_project.view.PostSubjectReviewView;

public class EvaluateActivity extends AppCompatActivity implements PostSubjectReviewView {
    TextView score;
    EditText review;
    RatingBar ratingBar;
    AppCompatButton button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        initView();
    }

    private void initView(){
        imageView = findViewById(R.id.subject_info_close_iv_js);
        score = findViewById(R.id.subject_info_score_avg_tv_js);
        review = findViewById(R.id.subject_info_eval_et_js);
        ratingBar = findViewById(R.id.ratingBarInficator);
        button = findViewById(R.id.subject_evaluate_post_btn_js);
    }

    @Override
    protected void onResume() {
        super.onResume();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 평가하기 버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createReview();
            }
        });
        // 레이팅바
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setRating(rating);
                score.setText(String.valueOf(ratingBar.getRating()));
            }
        });
    }
    // 강의평 작성 api
    private void createReview(){
        EvaluateSubjectService evaluateSubjectService = new EvaluateSubjectService();
        evaluateSubjectService.setPostSubjectReviewView(this);

        evaluateSubjectService.postSubjectReviews(getJwt(),getIntent().getIntExtra("subjectIdx",0),getReview()); //POST
    }
    // 강의평 작성 > 서버에 보낼 요청값
    private PostEvaluateSubjectReviewRequest getReview(){
        String content = review.getText().toString();
        float scoreText = Float.parseFloat(score.getText().toString());
        return new PostEvaluateSubjectReviewRequest(content,scoreText);
    }
    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }


    @Override
    public void onPostSubjectReviewsSuccess() {
        finish();
    }

    @Override
    public void onPostSubjectReviewsFailure(int code, String message) {

    }
}