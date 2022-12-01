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
import com.example.term_project.board.community_board.request.PatchCommunityRequest;
import com.example.term_project.board.community_board.request.PostCommunityRequest;
import com.example.term_project.board.community_board.response.result.PatchCommunityResult;
import com.example.term_project.view.PatchCommunityView;

public class CommunityEditActivity extends AppCompatActivity implements PatchCommunityView {
    TextView grade;
    EditText title,content;
    ImageView editCommunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_edit);
        initView();
    }
    private void initView(){
        grade = findViewById(R.id.community_edit_grade_number_tv_js);
        title = findViewById(R.id.community_edit_title_et_js);
        content = findViewById(R.id.community_edit_content_et_js);
        editCommunity = findViewById(R.id.community_menu_js);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getIntent().hasExtra("communityIdx")
                && getIntent().hasExtra("grade")
                && getIntent().hasExtra("title")
                && getIntent().hasExtra("content")){
            grade.setText(String.valueOf(getIntent().getIntExtra("grade",0)));
            title.setText(getIntent().getStringExtra("title"));
            content.setText(getIntent().getStringExtra("content"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        editCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCommunity();
            }
        });
    }

    private PatchCommunityRequest getData(){
        String titleText = title.getText().toString();
        String contentText = content.getText().toString();
        return new PatchCommunityRequest(titleText,contentText);
    }

    private void updateCommunity(){
        CommunityService communityService = new CommunityService();
        communityService.setPatchCommunityView(this);

        communityService.updateCommunity(getJwt(), getIntent().getIntExtra("communityIdx",0),getData());
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
    public void onPatchCommunitySuccess(int code, PatchCommunityResult result) {
        Intent intent = new Intent(CommunityEditActivity.this,CommunityBoardActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPatchCommunityFailure(int code, String message) {

    }
}