package com.example.term_project.view;

import com.example.term_project.board.community_board.response.result.GetIsAuthResult;

import java.util.ArrayList;

public interface GetIsAuthView {
    void onGetIsAuthSuccess(int code, GetIsAuthResult result);
    void onGetIsAuthFailure(int code, String message);
}
