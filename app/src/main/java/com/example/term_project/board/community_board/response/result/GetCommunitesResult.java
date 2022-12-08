package com.example.term_project.board.community_board.response.result;

import com.google.gson.annotations.SerializedName;

public class GetCommunitesResult {
    @SerializedName(value = "communutyIdx") private int communityIdx;
    @SerializedName(value = "userIdx") private int userIdx;
    @SerializedName(value = "grade") private int grade;
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "createdAt") private String createdAt;
    @SerializedName(value = "commentCount") private int commentCount;
    @SerializedName(value = "correctCreatedAt") private String correctCreatedAt;
    @SerializedName(value = "nickname") private String nickname;

    public GetCommunitesResult(int communityIdx, int userIdx, int grade, String title, String content, String createdAt, int commentCount, String correctCreatedAt, String nickname) {
        this.communityIdx = communityIdx;
        this.userIdx = userIdx;
        this.grade = grade;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.commentCount = commentCount;
        this.correctCreatedAt = correctCreatedAt;
        this.nickname = nickname;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getCorrectCreatedAt() {
        return correctCreatedAt;
    }

    public void setCorrectCreatedAt(String correctCreatedAt) {
        this.correctCreatedAt = correctCreatedAt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
