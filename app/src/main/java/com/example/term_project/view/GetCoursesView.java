package com.example.term_project.view;

import com.example.term_project.board.course.response.result.GetCourseListResult;

import java.util.ArrayList;

public interface GetCoursesView {
    void onGetCoursesSuccess(int code, ArrayList<GetCourseListResult> result);
    void onGetCoursesFailure(int code, String message);
}
