package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.term_project.board.community_board.CommunityService;
import com.example.term_project.board.community_board.response.result.GetCommentsResult;
import com.example.term_project.board.community_board.response.result.GetIsAuthResult;
import com.example.term_project.view.GetCommentsView;
import com.example.term_project.view.GetIsAuthView;

import java.util.ArrayList;

public class CommunityDetailActivity extends AppCompatActivity implements GetIsAuthView, GetCommentsView {
    TextView grade,title,content;
    ImageView imageView;
    RecyclerView recyclerView;
    CommunityDetailCommentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_detail);
        initView();
    }
    private void initView(){
        grade = findViewById(R.id.community_grade_number_tv_js);
        title = findViewById(R.id.community_detail_title_tv_js);
        content = findViewById(R.id.community_detail_content_tv_js);
        imageView = findViewById(R.id.community_menu_js);
    }
    private void initRecyclerView(ArrayList<GetCommentsResult> result){
        recyclerView = findViewById(R.id.community_comments_review_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CommunityDetailCommentsAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    private String getJwt(){
        SharedPreferences spf = this.getSharedPreferences("auth",AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    private void getIsAuth(String jwt){
        // 수정.삭제권한 api
        CommunityService communityService = new CommunityService();
        communityService.setGetIsAuthView(this);

        communityService.getIsAuth(jwt);

    }
    private void getList(int communityIdx){
        // 댓글api
        CommunityService communityService = new CommunityService();
        communityService.setGetCommentsView(this);

        communityService.getComments(communityIdx);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(getIntent().hasExtra("userIdx")){
            grade.setText(String.valueOf(getIntent().getIntExtra("grade",0)));
            title.setText(getIntent().getStringExtra("title"));
            content.setText(getIntent().getStringExtra("content"));
        }
        getIsAuth(getJwt());
    }

    @Override
    protected void onResume() {
        super.onResume();
        getList(getIntent().getIntExtra("communityIdx",0));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(CommunityDetailActivity.this,imageView);
                popupMenu.inflate(R.menu.exam_sub_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.edit:
                                Intent intent = new Intent(CommunityDetailActivity.this,CommunityEditActivity.class);
                                intent.putExtra("communityIdx",getIntent().getIntExtra("communityIdx",0));
                                intent.putExtra("grade",getIntent().getIntExtra("grade",0));
                                intent.putExtra("title",getIntent().getStringExtra("title"));
                                intent.putExtra("content",getIntent().getStringExtra("content"));
                                startActivity(intent);
                                return true;
                            case R.id.delete:
                                //삭제 api
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }


    @Override // api 응답값 & 인텐트로 넘어온 userIdx값 비교
    public void onGetIsAuthSuccess(int code, GetIsAuthResult result) {
        if (result.getUserIdx() == getIntent().getIntExtra("userIdx",0)){
            imageView.setVisibility(View.VISIBLE); // 자기가 쓴 글일 경우는 수정.삭제 가능
        }else{
            imageView.setVisibility(View.INVISIBLE); // 아닐 경우엔 불가능
        }
    }

    @Override
    public void onGetIsAuthFailure(int code, String message) {

    }

    @Override
    public void onGetCommentsSuccess(int code, ArrayList<GetCommentsResult> result) {
        initRecyclerView(result);
    }

    @Override
    public void onGetCommentsFailure(int code, String message) {

    }
}