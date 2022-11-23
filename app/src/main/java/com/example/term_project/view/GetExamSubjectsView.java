package com.example.term_project.view;

import com.example.term_project.board.exam_board.response.result.GetExamSubjectsResult;

import java.util.ArrayList;

public interface GetExamSubjectsView {
    void onGetExamSubjectSuccess(int code, ArrayList<GetExamSubjectsResult> result);
    void onGetExamSubjectFailure(int code, String message);
}
