package com.example.term_project.board.course;

import androidx.annotation.Nullable;

import com.example.term_project.board.community_board.response.GetCommunitesResponse;
import com.example.term_project.board.course.response.GetCourseListResponse;
import com.example.term_project.board.course.response.PostCourseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CourseRetrofitInterface {
    @GET("/app/boards/time-table/courses") // 학년별커뮤니티 게시글 조회
    Call<GetCourseListResponse> getCourses(@Query("grade") @Nullable Integer grade);
    @POST("/app/boards/time-table/courses/{courseIdx}")
    Call<PostCourseResponse> createCourse(@Header("X-ACCESS-TOKEN") String jwt, @Path("courseIdx") int courseIdx);
}
