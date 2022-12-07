package com.example.term_project.view;

import com.example.term_project.board.evaluate_board.response.result.GetSubjectInfoResult;


public interface GetSubjectInfoView {
    void onGetSubjectInfoSuccess(int code, GetSubjectInfoResult result);
    void onGetSubjectInfoFailure(int code, String message);
}
