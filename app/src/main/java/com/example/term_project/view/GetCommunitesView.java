package com.example.term_project.view;

import com.example.term_project.board.community_board.response.result.GetCommunitesResult;

import java.util.ArrayList;

public interface GetCommunitesView {
    void onGetCommunitesSuccess(int code, ArrayList<GetCommunitesResult> result);
    void onGetCommunitesFailure(int code, String message);
}
