package com.example.term_project.board.course;

import static com.example.term_project.network.NetworkModule.getRetrofit;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.term_project.board.course.response.GetCourseListResponse;
import com.example.term_project.board.course.response.GetTimeTableListResponse;
import com.example.term_project.board.course.response.PostCourseResponse;
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

    public void setGetCoursesView(GetCoursesView getCoursesView){
        this.getCoursesView = getCoursesView;
    }
    public void setPostCourseView(PostCourseView postCourseView){
        this.postCourseView = postCourseView;
    }
    public void setGetTimeTableView(GetTimeTableView getTimeTableView){
        this.getTimeTableView=getTimeTableView;
    }

    // GET
    public void getCourses(@Nullable Integer grade){
        Log.d("COURSE-INPUT", grade+"");
        courseService.getCourses(grade).enqueue(new Callback<GetCourseListResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetCourseListResponse> call, Response<GetCourseListResponse> response) {
                GetCourseListResponse resp = response.body();
                Log.d("COURSE-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    getCoursesView.onGetCoursesSuccess(resp.getCode(),resp.getResult());
                }else{
                    getCoursesView.onGetCoursesFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetCourseListResponse> call, Throwable t) {
                Log.d("COURSE/FAIL", t.getMessage());
            }
        });
        Log.d("COURSE","HELLO");
    }
    // POST
    public void createCourse(String jwt, int courseIdx){
        Log.d("COURSE-POST-INPUT", jwt+" "+courseIdx);
        courseService.createCourse(jwt,courseIdx).enqueue(new Callback<PostCourseResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<PostCourseResponse> call, Response<PostCourseResponse> response) {
                PostCourseResponse resp = response.body();
                Log.d("COURSE-POST-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    postCourseView.onPostCoursesSuccess(resp.getCode(),resp.getResult());
                }else{
                    postCourseView.onPostCoursesFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<PostCourseResponse> call, Throwable t) {
                Log.d("COURSE-POST/FAIL", t.getMessage());
            }
        });
        Log.d("COURSE-POST","HELLO");
    }
    // GET
    public void getTimeTable(String jwt){
        Log.d("TIME-TABLE-INPUT", jwt+"");
        courseService.getTimeTable(jwt).enqueue(new Callback<GetTimeTableListResponse>() {
            @Override // 응답이 왔을 때
            public void onResponse(Call<GetTimeTableListResponse> call, Response<GetTimeTableListResponse> response) {
                GetTimeTableListResponse resp = response.body();
                Log.d("TIME-TABLE-RESP", call.request().toString());
                assert resp != null;
                if(resp.getCode() == 1000){
                    getTimeTableView.onGetTimeTableSuccess(resp.getCode(),resp.getResult());
                }else{
                    getTimeTableView.onGetTimeTableFailure(resp.getCode(),resp.getMessage());
                }
            }
            @Override // 네트워크 연결 실패 시
            public void onFailure(Call<GetTimeTableListResponse> call, Throwable t) {
                Log.d("TIME-TABLE/FAIL", t.getMessage());
            }
        });
        Log.d("TIME-TABLE","HELLO");
    }
}
