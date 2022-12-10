package com.example.term_project.view;

import com.example.term_project.board.community_board.response.result.PostCommentResult;

public interface PostCommentView {
    void onPostCommentSuccess(int code, PostCommentResult result);
    void onPostCommentFailure(int code, String message);
}
