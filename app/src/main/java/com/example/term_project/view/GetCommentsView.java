package com.example.term_project.view;

import com.example.term_project.board.community_board.response.result.GetCommentsResult;

import java.util.ArrayList;

public interface GetCommentsView {
    void onGetCommentsSuccess(int code, ArrayList<GetCommentsResult> result);
    void onGetCommentsFailure(int code, String message);
}
