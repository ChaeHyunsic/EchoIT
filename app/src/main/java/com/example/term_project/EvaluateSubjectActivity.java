package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.term_project.board.evaluate_board.EvaluateSubjectService;
import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;
import com.example.term_project.view.GetEvaluateSubjectsView;

import java.util.ArrayList;

public class EvaluateSubjectActivity extends AppCompatActivity implements GetEvaluateSubjectsView {
    Spinner subjectGrade;
    ImageView closeEval;
    RecyclerView recyclerView;
    EvaluateSubjectAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate_subject);
        initView();
    }
    private void initView(){
        subjectGrade = findViewById(R.id.spinners);
        closeEval = findViewById(R.id.evaluate_board_close_iv_js);
    }
    // 리사이클러뷰 초기화
    private void initRecyclerView(ArrayList<GetEvaluateSubjectResult> result){
        recyclerView = findViewById(R.id.evaluate_sub_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EvaluateSubjectAdapter(result,this);
        recyclerView.setAdapter(adapter);
    }
    // 과목 목록 조회 api 호출 함수
    private void getList(Integer grade){
        EvaluateSubjectService evaluateSubjectService = new EvaluateSubjectService();
        evaluateSubjectService.setGetEvaluateSubjectsView(this);

        evaluateSubjectService.getEvaluateSubjects(grade); // GET
    }
    @Override
    protected void onResume() {
        super.onResume();
        subjectGrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 선택에 따른 조회
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(subjectGrade.getSelectedItem().toString().equals("전체")){
                    getList(null);
                }else{
                    getList(Integer.parseInt(subjectGrade.getSelectedItem().toString()));
                }
            }
            // 아무것도 선택 안했을 때 -> 전체조회
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                getList(null);
            }
        });
        closeEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    // 과목 목록 조회 api 호출 성공 시
    @Override
    public void onGetEvaluateSubjectSuccess(int code, ArrayList<GetEvaluateSubjectResult> result) {
        initRecyclerView(result);
    }

    @Override
    public void onGetEvaluateSubjectFailure(int code, String message) {

    }
}