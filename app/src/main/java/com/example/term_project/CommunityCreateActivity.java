package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.term_project.board.community_board.CommunityService;
import com.example.term_project.board.community_board.request.PostCommunityRequest;
import com.example.term_project.board.community_board.response.result.PostCommunityResult;
import com.example.term_project.view.PostCommunityView;

public class CommunityCreateActivity extends AppCompatActivity implements PostCommunityView {
    EditText title,content;
    ImageView closeCreated;
    AppCompatButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_create);
        initView();
    }
    private void initView(){
        title = findViewById(R.id.community_create_title_tv_js);
        content = findViewById(R.id.community_create_content_tv_js);
        closeCreated = findViewById(R.id.community_close_iv_js);
        button = findViewById(R.id.community_create_complete_btn_js);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCommunity();
            }
        });
        closeCreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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

        communityService.createCommunity(getJwt(), getData());
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
