package com.example.term_project.board.exam_board;

import static com.example.term_project.network.NetworkModule.getRetrofit;

import android.util.Log;

import com.example.term_project.view.ExamSubjectsView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExamSubjectService {
    private ExamSubjectsView examSubjectsView;
    public void setExamSubjectsView(ExamSubjectsView examSubjectsView){
        this.examSubjectsView = examSubjectsView;
    }
    public void getExamSubjects(String jwt){
        ExamSubjectRetrofitInterface authService = getRetrofit().create(ExamSubjectRetrofitInterface.class);
        authService.getExamSubjects(jwt).enqueue(new Callback<ExamSubjectResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<ExamSubjectResponse> call, Response<ExamSubjectResponse> response) {
                ExamSubjectResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    examSubjectsView.onGetExamSubjectSuccess(resp.getCode(),resp.getResult());
                }else{
                    examSubjectsView.onGetExamSubjectFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<ExamSubjectResponse> call, Throwable t) {
                Log.d("GET-EXAM-SUBJECT/FAIL", t.getMessage());
            }
        });
        Log.d("GET-EXAM-SUBJECT","HELLO");
    }
}
