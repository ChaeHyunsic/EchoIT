package com.example.term_project.board.course;

import static com.example.term_project.network.NetworkModule.getRetrofit;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.term_project.board.community_board.response.GetCommunitesResponse;
import com.example.term_project.board.course.response.GetCourseListResponse;
import com.example.term_project.view.GetCoursesView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseService {
    private final CourseRetrofitInterface courseService = getRetrofit().create(CourseRetrofitInterface.class);
    private GetCoursesView getCoursesView;

    public void setGetCoursesView(GetCoursesView getCoursesView){
        this.getCoursesView = getCoursesView;
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
}
