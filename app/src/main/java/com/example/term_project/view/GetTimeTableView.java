package com.example.term_project.view;

import com.example.term_project.board.course.response.result.GetTimeTableListResult;

import java.util.ArrayList;

public interface GetTimeTableView {
    void onGetTimeTableSuccess(int code, ArrayList<GetTimeTableListResult> result);
    void onGetTimeTableFailure(int code, String message);
}
