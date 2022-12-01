package com.example.term_project.view;

import com.example.term_project.board.community_board.response.result.DeleteCommunityResult;

public interface DeleteCommunityView {
    void onDeleteCommunitySuccess(int code, DeleteCommunityResult result);
    void onDeleteCommunityFailure(int code, String message);
}
