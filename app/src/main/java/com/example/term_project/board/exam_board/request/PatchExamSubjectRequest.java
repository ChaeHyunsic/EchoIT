package com.example.term_project.board.exam_board.request;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class PatchExamSubjectRequest {
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "endAt") private Date endAt;

    public PatchExamSubjectRequest(String title, String content, Date endAt) {
        this.title = title;
        this.content = content;
        this.endAt = endAt;
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
        return "PatchExamSubjectRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", endAt=" + endAt +
                '}';
    }
}
