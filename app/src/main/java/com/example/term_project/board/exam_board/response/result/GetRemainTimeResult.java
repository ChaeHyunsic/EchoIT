package com.example.term_project.board.exam_board.response.result;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class GetRemainTimeResult {
    @SerializedName(value = "boardIdx") private int boardIdx;
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "endAt") private String endAt;

    public GetRemainTimeResult(int boardIdx, String title, String content, String endAt) {
        this.boardIdx = boardIdx;
        this.title = title;
        this.content = content;
        this.endAt = endAt;
    }

    public int getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(int boardIdx) {
        this.boardIdx = boardIdx;
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

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }
}
