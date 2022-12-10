package com.example.term_project.board.course;

import static com.example.term_project.network.NetworkModule.getRetrofit;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.term_project.board.course.response.DeleteCourseResponse;
import com.example.term_project.board.course.response.GetCourseListResponse;
import com.example.term_project.board.course.response.GetTimeTableListResponse;
import com.example.term_project.board.course.response.PostCourseResponse;
import com.example.term_project.view.DeleteCourseView;
import com.example.term_project.view.GetCoursesView;
import com.example.term_project.view.GetTimeTableView;
import com.example.term_project.view.PostCourseView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseService {
    private final CourseRetrofitInterface courseService = getRetrofit().create(CourseRetrofitInterface.class);
    private GetCoursesView getCoursesView;
    private PostCourseView postCourseView;
    private GetTimeTableView getTimeTableView;
    private DeleteCourseView deleteCourseView;

    public void setGetCoursesView(GetCoursesView getCoursesView) {
        this.getCoursesView = getCoursesView;
    }

    public void setPostCourseView(PostCourseView postCourseView) {
        this.postCourseView = postCourseView;
    }

    public void setGetTimeTableView(GetTimeTableView getTimeTableView) {
        this.getTimeTableView = getTimeTableView;
    }

    public void setDeleteCourseView(DeleteCourseView deleteCourseView) {
        this.deleteCourseView = deleteCourseView;
    }

    // GET
    public void getCourses(@Nullable Integer grade) {
        courseService.getCourses(grade).enqueue(new Callback<GetCourseListResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetCourseListResponse> call, Response<GetCourseListResponse> response) {
                GetCourseListResponse resp = response.body();
                assert resp != null;
                if (resp.getCode() == 1000) {
                    getCoursesView.onGetCoursesSuccess(resp.getCode(), resp.getResult());
                } else {
                    getCoursesView.onGetCoursesFailure(resp.getCode(), resp.getMessage());
                }
            }

            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetCourseListResponse> call, Throwable t) {}
        });
    }

    // POST
    public void createCourse(String jwt, int courseIdx) {
        courseService.createCourse(jwt, courseIdx).enqueue(new Callback<PostCourseResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<PostCourseResponse> call, Response<PostCourseResponse> response) {
                PostCourseResponse resp = response.body();
                assert resp != null;
                if (resp.getCode() == 1000) {
                    postCourseView.onPostCoursesSuccess(resp.getCode(), resp.getResult());
                } else {
                    postCourseView.onPostCoursesFailure(resp.getCode(), resp.getMessage());
                }
            }

            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<PostCourseResponse> call, Throwable t) {}
        });
    }

    // GET
    public void getTimeTable(String jwt) {
        courseService.getTimeTable(jwt).enqueue(new Callback<GetTimeTableListResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetTimeTableListResponse> call, Response<GetTimeTableListResponse> response) {
                GetTimeTableListResponse resp = response.body();
                assert resp != null;
                if (resp.getCode() == 1000) {
                    getTimeTableView.onGetTimeTableSuccess(resp.getCode(), resp.getResult());
                } else {
                    getTimeTableView.onGetTimeTableFailure(resp.getCode(), resp.getMessage());
                }
            }

            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetTimeTableListResponse> call, Throwable t) {}
        });
    }

    // PATCH
    public void deleteCourse(String jwt, int timetableIdx) {
        courseService.deleteCourse(jwt, timetableIdx).enqueue(new Callback<DeleteCourseResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<DeleteCourseResponse> call, Response<DeleteCourseResponse> response) {
                DeleteCourseResponse resp = response.body();
                assert resp != null;
                if (resp.getCode() == 1000) {
                    deleteCourseView.onDeleteCommunitySuccess(resp.getCode(), resp.getResult());
                } else {
                    deleteCourseView.onDeleteCommunityFailure(resp.getCode(), resp.getMessage());
                }
            }

            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<DeleteCourseResponse> call, Throwable t) {}
        });
    }
}
