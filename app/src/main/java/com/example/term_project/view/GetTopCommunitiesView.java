package com.example.term_project.view;

import com.example.term_project.board.community_board.response.result.GetTopCommunitiesResult;

import java.util.ArrayList;

public interface GetTopCommunitiesView {
    void onGetTopCommunitiesViewSuccess(int code, ArrayList<GetTopCommunitiesResult> result);
    void onGetTopCommunitiesViewFailure(int code, String message);
}
