package com.example.term_project.view;

import com.example.term_project.board.exam_board.response.result.PostExamSubjectResult;

public interface PostExamSubjectView {
    void onPostExamSubjectSuccess(int code, PostExamSubjectResult result);
    void onPostExamSubjectFailure(int code, String message);
}
