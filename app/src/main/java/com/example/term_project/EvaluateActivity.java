package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.term_project.board.evaluate_board.EvaluateSubjectService;
import com.example.term_project.board.evaluate_board.request.PostEvaluateSubjectReviewRequest;
import com.example.term_project.view.PostSubjectReviewView;

public class EvaluateActivity extends AppCompatActivity implements PostSubjectReviewView {
    TextView subjectName,professor,score;
    EditText review;
    RatingBar ratingBar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        initView();
    }

    private void initView(){
        subjectName = findViewById(R.id.selected_subject_name);
        professor = findViewById(R.id.professor_name_js);
        score = findViewById(R.id.score_tv_js);
        review = findViewById(R.id.post_review_et_js);
        ratingBar = findViewById(R.id.evaluate_score_rb_js);
        button = findViewById(R.id.evaluate_review_complete_btn_js);
    }

    @Override
    protected void onStart() {
        super.onStart();
            if(getIntent().hasExtra("subjectName") && getIntent().hasExtra("professor")){
                subjectName.setText(getIntent().getStringExtra("subjectName"));
                professor.setText(getIntent().getStringExtra("professor"));
            }
    }

    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createReview();
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setRating(rating);
                score.setText(String.valueOf(ratingBar.getRating()));
            }
        });
    }
    private void createReview(){
        EvaluateSubjectService evaluateSubjectService = new EvaluateSubjectService();
        evaluateSubjectService.setPostSubjectReviewView(this);

        evaluateSubjectService.postSubjectReviews(getJwt(),getIntent().getIntExtra("subjectIdx",0),getReview());
    }
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