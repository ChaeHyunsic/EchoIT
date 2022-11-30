package com.example.term_project.board.community_board.response.result;

import com.google.gson.annotations.SerializedName;

public class GetIsAuthResult {
    @SerializedName(value = "userIdx") private int userIdx;

    public GetIsAuthResult(int userIdx) {
        this.userIdx = userIdx;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }
}
