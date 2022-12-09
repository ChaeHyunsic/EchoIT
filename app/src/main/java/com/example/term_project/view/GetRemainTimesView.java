package com.example.term_project.view;

import com.example.term_project.board.exam_board.response.result.GetRemainTimeResult;

import java.util.ArrayList;

public interface GetRemainTimesView {
    void onGetRemainTimesSuccess(int code, ArrayList<GetRemainTimeResult> result);
    void onGetRemainTimesFailure(int code, String message);
}
