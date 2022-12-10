package com.example.term_project.board.community_board.response.result;

import com.google.gson.annotations.SerializedName;

public class PostCommunityResult {
    @SerializedName(value = "userIdx") private int userIdx;
    @SerializedName(value = "grade") private int grade;
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "content") private String content;

    public PostCommunityResult(int userIdx, int grade, String title, String content) {
        this.userIdx = userIdx;
        this.grade = grade;
        this.title = title;
        this.content = content;
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
}
