package com.example.term_project.view;

import com.example.term_project.board.community_board.response.result.PostCommunityResult;

public interface PostCommunityView {
    void onPostCommunitySuccess(int code, PostCommunityResult result);
    void onPostCommunityFailure(int code, String message);
}
