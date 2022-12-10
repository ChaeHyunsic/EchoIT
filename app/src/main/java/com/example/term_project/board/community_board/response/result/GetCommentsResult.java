package com.example.term_project.board.community_board.response.result;

import com.google.gson.annotations.SerializedName;

public class GetCommentsResult {
    @SerializedName(value = "commentIdx") private int commentIdx;
    @SerializedName(value = "userIdx") private int userIdx;
    @SerializedName(value = "nickname") private String nickname;
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "correctCreatedAt") private String correctCreatedAt;


    public GetCommentsResult(int communityIdx, int userIdx, String nickname, String content, String correctCreatedAt) {
        this.commentIdx = communityIdx;
        this.userIdx = userIdx;
        this.nickname = nickname;
        this.content = content;
        this.correctCreatedAt = correctCreatedAt;
    }

    public int getCommentIdx() {
        return commentIdx;
    }

    public void setCommentIdx(int communityIdx) {
        this.commentIdx = communityIdx;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCorrectCreatedAt() {
        return correctCreatedAt;
    }

    public void setCorrectCreatedAt(String correctCreatedAt) {
        this.correctCreatedAt = correctCreatedAt;
    }
}
