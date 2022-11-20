package com.example.term_project.board.exam_board;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ExamSubjectRetrofitInterface {
    @GET("/app/boards/exam-subjects")
    Call<ExamSubjectResponse> getExamSubjects(@Header("X-ACCESS-TOKEN") String jwt);
}
