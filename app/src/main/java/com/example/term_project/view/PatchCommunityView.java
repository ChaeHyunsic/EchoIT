package com.example.term_project.view;

import com.example.term_project.board.community_board.response.result.PatchCommunityResult;

public interface PatchCommunityView {
    void onPatchCommunitySuccess(int code, PatchCommunityResult result);
    void onPatchCommunityFailure(int code, String message);
}
