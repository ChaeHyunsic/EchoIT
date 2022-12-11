package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

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
    EditText title,content;
    ImageView closeEdit;
    AppCompatButton editCommunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_edit);
        initView();
    }
    private void initView(){
        title = findViewById(R.id.community_edit_title_et_js);
        content = findViewById(R.id.community_edit_content_et_js);
        closeEdit = findViewById(R.id.community_close_iv_js);
        editCommunity = findViewById(R.id.community_edit_complete_btn_js);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 이전 액티비티에서 받은 인텐트값 세팅
        if(getIntent().hasExtra("communityIdx")
                && getIntent().hasExtra("title")
                && getIntent().hasExtra("content")){
            title.setText(getIntent().getStringExtra("title"));
            content.setText(getIntent().getStringExtra("content"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        closeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        editCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCommunity(); // 수정 api 호출
            }
        });
    }

    // 서버에 보낼 요청 값 함수
    private PatchCommunityRequest getData(){
        String titleText = title.getText().toString();
        String contentText = content.getText().toString();
        return new PatchCommunityRequest(titleText,contentText);
    }
    // 수정 api
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

    // 수정 api 호출 성공 시시
    @Override
    public void onPatchCommunitySuccess(int code, PatchCommunityResult result) {
        Intent intent = new Intent(CommunityEditActivity.this,CommunityDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPatchCommunityFailure(int code, String message) {

    }
}