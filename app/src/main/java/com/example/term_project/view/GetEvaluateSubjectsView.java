package com.example.term_project.view;

import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;

import java.util.ArrayList;

public interface GetEvaluateSubjectsView {
    void onGetEvaluateSubjectSuccess(int code, ArrayList<GetEvaluateSubjectResult> result);
    void onGetEvaluateSubjectFailure(int code, String message);
}
