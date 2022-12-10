package com.example.term_project.board.community_board.response.result;

import com.google.gson.annotations.SerializedName;

public class DeleteCommunityResult {
    @SerializedName(value = "communutyIdx") private int communityIdx;
    @SerializedName(value = "status") private String status;

    public DeleteCommunityResult(int communityIdx, String status) {
        this.communityIdx = communityIdx;
        this.status = status;
    }

    public int getCommunityIdx() {
        return communityIdx;
    }

    public void setCommunityIdx(int communityIdx) {
        this.communityIdx = communityIdx;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
