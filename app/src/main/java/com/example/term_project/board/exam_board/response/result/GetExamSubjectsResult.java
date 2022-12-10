package com.example.term_project.board.exam_board.response.result;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class GetExamSubjectsResult {
    @SerializedName(value = "id") private int id;
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "endAt") private Date endAt;

    public GetExamSubjectsResult(int id, String title, String content, Date endAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.endAt = endAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "GetExamSubjectsResult{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", endAt=" + endAt +
                '}';
    }
}
