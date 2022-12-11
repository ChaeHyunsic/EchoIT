package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.term_project.board.community_board.CommunityService;
import com.example.term_project.board.community_board.request.PatchCommunityRequest;
import com.example.term_project.board.community_board.request.PostCommentRequest;
import com.example.term_project.board.community_board.response.result.DeleteCommunityResult;
import com.example.term_project.board.community_board.response.result.GetCommentsResult;
import com.example.term_project.board.community_board.response.result.GetCommunitesResult;
import com.example.term_project.board.community_board.response.result.GetIsAuthResult;
import com.example.term_project.board.community_board.response.result.PostCommentResult;
import com.example.term_project.view.DeleteCommunityView;
import com.example.term_project.view.GetCommentsView;
import com.example.term_project.view.GetCommunitesView;
import com.example.term_project.view.GetIsAuthView;
import com.example.term_project.view.PostCommentView;

import java.util.ArrayList;

public class CommunityDetailActivity extends AppCompatActivity implements GetIsAuthView, GetCommentsView, DeleteCommunityView, PostCommentView {
    TextView nickname,correctCreatedAt,title,content;
    ImageView imageView,closeDetail;
    RecyclerView recyclerView;
    CommunityDetailCommentsAdapter adapter;
    EditText comment;
    ImageView send;
    InputMethodManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_detail);
        initView();
    }
    private void initView(){
        nickname = findViewById(R.id.community_detail_nickname_tv_js);
        correctCreatedAt = findViewById(R.id.community_detail_created_tv_js);
        title = findViewById(R.id.community_detail_title_tv_js);
        content = findViewById(R.id.community_detail_content_tv_js);
        imageView = findViewById(R.id.community_menu_js);
        closeDetail = findViewById(R.id.community_close_iv_js);
        comment = findViewById(R.id.comment_send_et_js);
        send = findViewById(R.id.comment_send_iv_js);
        manager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
    }
    private void initRecyclerView(ArrayList<GetCommentsResult> result){
        recyclerView = findViewById(R.id.community_comments_review_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CommunityDetailCommentsAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    // 수정.삭제권한 api
    private void getIsAuth(String jwt){
        CommunityService communityService = new CommunityService();
        communityService.setGetIsAuthView(this);

        communityService.getIsAuth(jwt);

    }
    // 댓글 api
    private void getList(int communityIdx){
        CommunityService communityService = new CommunityService();
        communityService.setGetCommentsView(this);

        communityService.getComments(communityIdx);
    }
    // 게시물 삭제 api
    private void deleteData(String jwt,int communityIdx){
        CommunityService communityService = new CommunityService();
        communityService.setDeleteCommunityView(this);

        communityService.deleteCommunity(jwt,communityIdx);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(getIntent().hasExtra("userIdx")){
            nickname.setText(getIntent().getStringExtra("nickname"));
            correctCreatedAt.setText(getIntent().getStringExtra("correctCreatedAt"));
            title.setText(getIntent().getStringExtra("title"));
            content.setText(getIntent().getStringExtra("content"));
        }
        getIsAuth(getJwt()); // 권한 api 호출
    }

    @Override
    protected void onResume() {
        super.onResume();
        getList(getIntent().getIntExtra("communityIdx",0));
        closeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(CommunityDetailActivity.this,imageView);
                popupMenu.inflate(R.menu.exam_sub_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.edit: // 수정 액티비티 이동
                                Intent intent = new Intent(CommunityDetailActivity.this,CommunityEditActivity.class);
                                intent.putExtra("communityIdx",getIntent().getIntExtra("communityIdx",0));
                                intent.putExtra("title",getIntent().getStringExtra("title"));
                                intent.putExtra("content",getIntent().getStringExtra("content"));
                                startActivity(intent);
                                return true;
                            case R.id.delete: // 삭제 api
                                deleteData(getJwt(),getIntent().getIntExtra("communityIdx",0));
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createComment();
                hideKeyboard(send);
                comment.setText("");
            }
        });
    }
    private void hideKeyboard(View view)
    {
        InputMethodManager inputMethodManager = this.manager;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private PostCommentRequest getPostData(){
        String commentText = comment.getText().toString();
        return new PostCommentRequest(getIntent().getIntExtra("communityIdx",0),commentText);
    }

    private void createComment(){
        CommunityService communityService = new CommunityService();
        communityService.setPostCommentView(this);

        communityService.createComment(getJwt(), getPostData());
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

    @Override
    public void onDeleteCommunitySuccess(int code, DeleteCommunityResult result) {
        finish();
    }

    @Override
    public void onDeleteCommunityFailure(int code, String message) {

    }

    @Override
    public void onPostCommentSuccess(int code, PostCommentResult result) {
        getList(getIntent().getIntExtra("communityIdx",0));
        comment.clearFocus();
    }

    @Override
    public void onPostCommentFailure(int code, String message) {

    }
}