package com.example.term_project.board.community_board.response.result;

import com.google.gson.annotations.SerializedName;

public class PatchCommunityResult {
    @SerializedName(value = "communityIdx") private int communityIdx;
    @SerializedName(value = "userIdx") private int userIdx;
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "content") private String content;

    public PatchCommunityResult(int communityIdx, int userIdx, String title, String content) {
        this.communityIdx = communityIdx;
        this.userIdx = userIdx;
        this.title = title;
        this.content = content;
    }

    public int getCommunityIdx() {
        return communityIdx;
    }

    public void setCommunityIdx(int communityIdx) {
        this.communityIdx = communityIdx;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
