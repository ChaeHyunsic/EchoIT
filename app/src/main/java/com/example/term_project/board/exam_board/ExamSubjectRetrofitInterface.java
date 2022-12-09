package com.example.term_project.board.exam_board;

import com.example.term_project.board.exam_board.request.PatchExamSubjectRequest;
import com.example.term_project.board.exam_board.request.PostExamSubjectRequest;
import com.example.term_project.board.exam_board.response.DeleteExamSubjectResponse;
import com.example.term_project.board.exam_board.response.GetExamSubjectResponse;
import com.example.term_project.board.exam_board.response.GetRemainTimeResponse;
import com.example.term_project.board.exam_board.response.PatchExamSubjectResponse;
import com.example.term_project.board.exam_board.response.PostExamSubjectResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ExamSubjectRetrofitInterface {
    @GET("/app/boards/exam-subjects") // 조회
    Call<GetExamSubjectResponse> getExamSubjects(@Header("X-ACCESS-TOKEN") String jwt);
    @POST("/app/boards/exam-subjects") // 추가
    Call<PostExamSubjectResponse> postExamSubject(@Header("X-ACCESS-TOKEN") String jwt, @Body PostExamSubjectRequest postExamSubjectRequest);
    @PATCH("/app/boards/exam-subjects/{listIdx}") // 수정
    Call<PatchExamSubjectResponse> patchExamSubject(@Header("X-ACCESS-TOKEN") String jwt, @Path("listIdx") int listIdx, @Body PatchExamSubjectRequest postExamSubjectRequest);
    @PATCH("/app/boards/exam-subjects/del/{listIdx}") // 삭제
    Call<DeleteExamSubjectResponse> deleteExamSubject(@Header("X-ACCESS-TOKEN") String jwt, @Path("listIdx") int listIdx);
    @GET("/app/boards/exam-subjects/remain-times")
    Call<GetRemainTimeResponse> getRemainTimes(@Header("X-ACCESS-TOKEN") String jwt);
}
