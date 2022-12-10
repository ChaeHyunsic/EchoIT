package com.example.term_project.board.evaluate_board;

import static com.example.term_project.network.NetworkModule.getRetrofit;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.term_project.board.evaluate_board.request.PostEvaluateSubjectReviewRequest;
import com.example.term_project.board.evaluate_board.response.GetEvaluateSubjectResponse;
import com.example.term_project.board.evaluate_board.response.GetSubjectInfoResponse;
import com.example.term_project.board.evaluate_board.response.GetSubjectReviewsResponse;
import com.example.term_project.board.evaluate_board.response.GetTopReviewsResponse;
import com.example.term_project.board.evaluate_board.response.PostSubjectReviewsResponse;
import com.example.term_project.view.GetEvaluateSubjectsView;
import com.example.term_project.view.GetSubjectInfoView;
import com.example.term_project.view.GetSubjectReviewsView;
import com.example.term_project.view.GetTopReviewsView;
import com.example.term_project.view.PostSubjectReviewView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EvaluateSubjectService {
    private final EvaluateSubjectRetrofitInterface evaluateSubjectService = getRetrofit().create(EvaluateSubjectRetrofitInterface.class);
    private GetEvaluateSubjectsView getEvaluateSubjectsView;
    private GetSubjectInfoView getSubjectInfoView;
    private GetSubjectReviewsView getSubjectReviewsView;
    private PostSubjectReviewView postSubjectReviewView;
    private GetTopReviewsView getTopReviewsView;

    public void setGetEvaluateSubjectsView(GetEvaluateSubjectsView getEvaluateSubjectsView){
        this.getEvaluateSubjectsView = getEvaluateSubjectsView;
    }
    public void setGetSubjectInfoView(GetSubjectInfoView getSubjectInfoView){
        this.getSubjectInfoView = getSubjectInfoView;
    }
    public void setGetSubjectReviewsView(GetSubjectReviewsView getSubjectReviewsView){
        this.getSubjectReviewsView = getSubjectReviewsView;
    }
    public void setPostSubjectReviewView(PostSubjectReviewView postSubjectReviewView){
        this.postSubjectReviewView = postSubjectReviewView;
    }
    public void setGetTopReviewsView(GetTopReviewsView getTopReviewsView){
        this.getTopReviewsView = getTopReviewsView;
    }

    // GET
    public void getEvaluateSubjects(@Nullable Integer grade){
        Log.d("EVALUATE-SUBJECT-INPUT", grade+"");
        evaluateSubjectService.getEvaluateSubjects(grade).enqueue(new Callback<GetEvaluateSubjectResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetEvaluateSubjectResponse> call, Response<GetEvaluateSubjectResponse> response) {
                GetEvaluateSubjectResponse resp = response.body();
                Log.d("EVALUATE-SUBJECT-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    getEvaluateSubjectsView.onGetEvaluateSubjectSuccess(resp.getCode(),resp.getResult());
                }else{
                    getEvaluateSubjectsView.onGetEvaluateSubjectFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetEvaluateSubjectResponse> call, Throwable t) {
                Log.d("EVALUATE-SUBJECTS/FAIL", t.getMessage());
            }
        });
        Log.d("EVALUATE-SUBJECTS","HELLO");
    }
    // GET
    public void getSubjectInfo(int subjectIdx){
        Log.d("SUBJECT-INFO-INPUT", subjectIdx+"");
        evaluateSubjectService.getSubjectInfo(subjectIdx).enqueue(new Callback<GetSubjectInfoResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetSubjectInfoResponse> call, Response<GetSubjectInfoResponse> response) {
                GetSubjectInfoResponse resp = response.body();
                Log.d("SUBJECT-INFO-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    Log.d("WHY?", String.valueOf(resp.getResult().getScoreAverage()));
                    getSubjectInfoView.onGetSubjectInfoSuccess(resp.getCode(),resp.getResult());
                }else{
                    getSubjectInfoView.onGetSubjectInfoFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetSubjectInfoResponse> call, Throwable t) {
                Log.d("SUBJECT-INFO/FAIL", t.getMessage());
            }
        });
        Log.d("SUBJECT-INFO","HELLO");
    }
    // GET
    public void getSubjectReviews(int subjectIdx){
        Log.d("SUBJECT-REVIEW-INPUT", subjectIdx+"");
        evaluateSubjectService.getSubjectReviews(subjectIdx).enqueue(new Callback<GetSubjectReviewsResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetSubjectReviewsResponse> call, Response<GetSubjectReviewsResponse> response) {
                GetSubjectReviewsResponse resp = response.body();
                Log.d("SUBJECTS-REVIEWS-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    getSubjectReviewsView.onGetSubjectReviewsSuccess(resp.getCode(),resp.getResult());
                }else{
                    getSubjectReviewsView.onGetSubjectReviewsFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetSubjectReviewsResponse> call, Throwable t) {
                Log.d("SUBJECTS-REVIEWS/FAIL", t.getMessage());
            }
        });
        Log.d("SUBJECTS-REVIEWS","HELLO");
    }
    //POST
    public void postSubjectReviews(String jwt, int subjectIdx, PostEvaluateSubjectReviewRequest postEvaluateSubjectReviewRequest){
        Log.d("REVIEW-POST-PARAM", jwt+"\n"+subjectIdx);
        evaluateSubjectService.createSubjectReview(jwt,subjectIdx,postEvaluateSubjectReviewRequest).enqueue(new Callback<PostSubjectReviewsResponse>() {
            @Override
            public void onResponse(Call<PostSubjectReviewsResponse> call, Response<PostSubjectReviewsResponse> response) {
                PostSubjectReviewsResponse resp = response.body();
                assert resp != null;
                if(resp.getCode() == 1000){
                    postSubjectReviewView.onPostSubjectReviewsSuccess();
                }else{
                    postSubjectReviewView.onPostSubjectReviewsFailure(resp.getCode(),resp.getMessage());
                }
            }

            @Override
            public void onFailure(Call<PostSubjectReviewsResponse> call, Throwable t) {
                Log.d("POST-REVIEW/FAIL", t.getMessage());
            }
        });
        Log.d("POST-REVIEW","HELLO");
    }
    // GET
    public void getTopReviews(){
        evaluateSubjectService.getTopReviews().enqueue(new Callback<GetTopReviewsResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetTopReviewsResponse> call, Response<GetTopReviewsResponse> response) {
                GetTopReviewsResponse resp = response.body();
                Log.d("SUBJECTS-REVIEWS-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    getTopReviewsView.onGetTopReviewsSuccess(resp.getCode(),resp.getResult());
                }else{
                    getTopReviewsView.onGetTopReviewsFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetTopReviewsResponse> call, Throwable t) {
                Log.d("SUBJECTS-REVIEWS/FAIL", t.getMessage());
            }
        });
        Log.d("SUBJECTS-REVIEWS","HELLO");
    }
}
