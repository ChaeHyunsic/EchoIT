package com.example.term_project;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.term_project.board.community_board.CommunityService;
import com.example.term_project.board.community_board.response.result.GetCommunitesResult;
import com.example.term_project.board.exam_board.ExamSubjectService;
import com.example.term_project.board.exam_board.response.result.GetRemainTimeResult;
import com.example.term_project.view.GetRemainTimesView;

import java.util.ArrayList;

public class NotifyFragment extends Fragment implements GetRemainTimesView {
    RecyclerView recyclerView;
    NotifyAdapter adapter;
    View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_notify, container, false);
        getList(); // api 호출
        return root;
    }
    private String getJwt(){
        SharedPreferences spf = this.getActivity().getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE);
        return spf.getString("jwt","");
    }
    private void initRecyclerView(ArrayList<GetRemainTimeResult> result){
        recyclerView = root.findViewById(R.id.notify_remain_time_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new NotifyAdapter(result,getActivity());
        recyclerView.setAdapter(adapter);
    }

    // 얼마 남지않은 시험/과제 일정 조회 api
    private void getList(){
        ExamSubjectService examSubjectService = new ExamSubjectService();
        examSubjectService.setGetRemainTimesView(this);

        examSubjectService.getRemainTimes(getJwt());
    }

    @Override
    public void onGetRemainTimesSuccess(int code, ArrayList<GetRemainTimeResult> result) {
        initRecyclerView(result); // 응답값들을 리사이클러뷰에 표시
    }

    @Override
    public void onGetRemainTimesFailure(int code, String message) {

    }
}