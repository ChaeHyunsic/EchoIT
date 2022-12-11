package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.term_project.board.community_board.CommunityService;
import com.example.term_project.board.community_board.response.result.GetCommunitesResult;
import com.example.term_project.view.GetCommunitesView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class CommunityBoardActivity extends AppCompatActivity implements GetCommunitesView {
    Spinner communityGrade;
    ImageView imageView;
    RecyclerView recyclerView;
    CommunityBoardAdapter adapter;
    ExtendedFloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_board);
        initView();
    }
    private void initView(){
        communityGrade = findViewById(R.id.community_spinners_js);
        floatingActionButton = findViewById(R.id.community_plus_fab_js);
        imageView = findViewById(R.id.community_close_iv_js);
    }
    private void initRecyclerView(ArrayList<GetCommunitesResult> result){
        recyclerView = findViewById(R.id.community_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CommunityBoardAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    // 커뮤니티 목록 조회 api
    private void getList(Integer grade){
        CommunityService communityService = new CommunityService();
        communityService.setGetCommunitesView(this);

        communityService.getCommunities(grade); // GET
    }

    @Override
    protected void onStart() {
        super.onStart();
        getList(null); // api 호출
    }

    @Override
    protected void onResume() {
        super.onResume();
        communityGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 선택에 따른 조회
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(communityGrade.getSelectedItem().toString().equals("전체")){
                    getList(null);
                }else{
                    getList(Integer.parseInt(communityGrade.getSelectedItem().toString()));
                }
            }
            // 아무것도 선택 안했을 때 -> 전체조회
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                getList(null);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommunityBoardActivity.this,CommunityCreateActivity.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    public void onGetCommunitesSuccess(int code, ArrayList<GetCommunitesResult> result) {
        initRecyclerView(result);
    }

    @Override
    public void onGetCommunitesFailure(int code, String message) {

    }
}