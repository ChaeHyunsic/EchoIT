package com.example.term_project.board.course;

import androidx.annotation.Nullable;

import com.example.term_project.board.community_board.response.GetCommunitesResponse;
import com.example.term_project.board.course.response.GetCourseListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CourseRetrofitInterface {
    @GET("/app/boards/time-table/courses") // 학년별커뮤니티 게시글 조회
    Call<GetCourseListResponse> getCourses(@Query("grade") @Nullable Integer grade);
}
