package com.example.term_project.board.evaluate_board;

import androidx.annotation.Nullable;

import com.example.term_project.board.evaluate_board.response.GetEvaluateSubjectResponse;
import com.example.term_project.board.evaluate_board.response.GetSubjectInfoResponse;
import com.example.term_project.board.evaluate_board.response.GetSubjectReviewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EvaluateSubjectRetrofitInterface {
    @GET("/app/boards/evaluation-subjects") // 과목목록조회
    Call<GetEvaluateSubjectResponse> getEvaluateSubjects(@Query("grade") @Nullable Integer grade);
    @GET("/app/boards/evaluation-subjects/{subjectIdx}") // 과목상단정보조회
    Call<GetSubjectInfoResponse> getSubjectInfo(@Path("subjectIdx") int subjectIdx);
    @GET("/app/boards/evaluation-subjects/reviews/{subjectIdx}") // 후기목록조회
    Call<GetSubjectReviewsResponse> getSubjectReviews(@Path("subjectIdx") int subjectIdx);
}
