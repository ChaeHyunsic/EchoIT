package com.example.term_project.view;

import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;
import com.example.term_project.board.evaluate_board.response.result.GetSubjectInfoResult;

import java.util.ArrayList;

public interface GetSubjectInfoView {
    void onGetSubjectInfoSuccess(int code, GetSubjectInfoResult result);
    void onGetSubjectInfoFailure(int code, String message);
}
