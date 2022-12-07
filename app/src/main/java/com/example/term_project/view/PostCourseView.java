package com.example.term_project.view;

import com.example.term_project.board.course.response.result.PostCourseResult;

public interface PostCourseView {
    void onPostCoursesSuccess(int code, PostCourseResult result);
    void onPostCoursesFailure(int code, String message);
}
