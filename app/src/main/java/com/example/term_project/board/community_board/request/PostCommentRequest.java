package com.example.term_project.board.community_board.request;

import com.google.gson.annotations.SerializedName;

public class PostCommentRequest {
    @SerializedName(value = "communityIdx") private int communityIdx;
    @SerializedName(value = "content") private String content;

    public PostCommentRequest(int communityIdx, String content) {
        this.communityIdx = communityIdx;
        this.content = content;
    }

    public int getCommunityIdx() {
        return communityIdx;
    }

    public void setCommunityIdx(int communityIdx) {
        this.communityIdx = communityIdx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
