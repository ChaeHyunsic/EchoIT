package com.example.term_project.view;


import com.example.term_project.board.course.response.result.DeleteCourseResult;

public interface DeleteCourseView {
    void onDeleteCommunitySuccess(int code, DeleteCourseResult result);
    void onDeleteCommunityFailure(int code, String message);
}
