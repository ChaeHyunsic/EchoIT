package com.example.term_project.board.exam_board.response.result;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class PostExamSubjectResult {
    @SerializedName(value = "listIdx") private int listIdx;
    @SerializedName(value = "userIdx") private int userIdx;
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "endAt") private Date endAt;

    public PostExamSubjectResult(int listIdx, int userIdx, String title, String content, Date endAt) {
        this.listIdx = listIdx;
        this.userIdx = userIdx;
        this.title = title;
        this.content = content;
        this.endAt = endAt;
    }

    public int getListIdx() {
        return listIdx;
    }

    public void setListIdx(int listIdx) {
        this.listIdx = listIdx;
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

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    @Override
    public String toString() {
        return "PostExamSubjectResult{" +
                "listIdx=" + listIdx +
                ", userIdx=" + userIdx +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", endAt=" + endAt +
                '}';
    }
}
