package com.example.term_project.board.evaluate_board;

import androidx.annotation.Nullable;

import com.example.term_project.board.evaluate_board.request.PostEvaluateSubjectReviewRequest;
import com.example.term_project.board.evaluate_board.response.GetEvaluateSubjectResponse;
import com.example.term_project.board.evaluate_board.response.GetSubjectInfoResponse;
import com.example.term_project.board.evaluate_board.response.GetSubjectReviewsResponse;
import com.example.term_project.board.evaluate_board.response.PostSubjectReviewsResponse;
import com.example.term_project.board.evaluate_board.response.GetTopReviewsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EvaluateSubjectRetrofitInterface {
    @GET("/app/boards/evaluation-subjects") // 과목목록조회
    Call<GetEvaluateSubjectResponse> getEvaluateSubjects(@Query("grade") @Nullable Integer grade);
    @GET("/app/boards/evaluation-subjects/{subjectIdx}") // 과목상단정보조회
    Call<GetSubjectInfoResponse> getSubjectInfo(@Path("subjectIdx") int subjectIdx);
    @GET("/app/boards/evaluation-subjects/reviews/{subjectIdx}") // 후기목록조회
    Call<GetSubjectReviewsResponse> getSubjectReviews(@Path("subjectIdx") int subjectIdx);
    @POST("/app/boards/evaluation-subjects/reviews/{subjectIdx}") // 후기 작성
    Call<PostSubjectReviewsResponse> createSubjectReview(@Header("X-ACCESS-TOKEN") String jwt, @Path("subjectIdx") int subjectIdx, @Body PostEvaluateSubjectReviewRequest postEvaluateSubjectReviewRequest);
    @GET("/app/boards/evaluation-subjects/reviews/top-ranks") // 최근 강의평 4개
    Call<GetTopReviewsResponse> getTopReviews();
}
