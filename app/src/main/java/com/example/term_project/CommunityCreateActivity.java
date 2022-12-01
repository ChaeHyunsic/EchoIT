package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.term_project.board.community_board.CommunityService;
import com.example.term_project.board.community_board.request.PostCommunityRequest;
import com.example.term_project.board.community_board.response.result.PostCommunityResult;
import com.example.term_project.view.PostCommunityView;

public class CommunityCreateActivity extends AppCompatActivity implements PostCommunityView {
    TextView grade;
    EditText title,content;
    ImageView createCommunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_create);
        initView();
    }
    private void initView(){
        grade = findViewById(R.id.community_create_grade_number_tv_js);
        title = findViewById(R.id.community_create_title_tv_js);
        content = findViewById(R.id.community_create_content_tv_js);
        createCommunity = findViewById(R.id.community_menu_js);
    }

    @Override
    protected void onStart() {
        super.onStart();
        grade.setText(String.valueOf(getGrade()));

    }
    private int getGrade(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getInt("grade",0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCommunity();
            }
        });
    }
    private PostCommunityRequest getData(){
        String titleText = title.getText().toString();
        String contentText = content.getText().toString();
        return new PostCommunityRequest(titleText,contentText);
    }
    private void createCommunity(){
        CommunityService communityService = new CommunityService();
        communityService.setPostCommunityView(this);

        communityService.createComment(getJwt(), getData());
    }
    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onPostCommunitySuccess(int code, PostCommunityResult result) {
        Intent intent = new Intent(CommunityCreateActivity.this,CommunityBoardActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPostCommunityFailure(int code, String message) {

    }
}
