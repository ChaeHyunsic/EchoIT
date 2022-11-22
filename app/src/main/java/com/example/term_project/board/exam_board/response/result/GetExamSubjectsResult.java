package com.example.term_project.board.exam_board.response.result;

import com.google.gson.annotations.SerializedName;

public class GetExamSubjectsResult {
    @SerializedName(value = "id") private int id;
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "endAt") private String endAt;

    public GetExamSubjectsResult(int id, String title, String endAt) {
        this.id = id;
        this.title = title;
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

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    @Override
    public String toString() {
        return "ExamSubjects{" +
                "listIdx=" + id +
                ", title='" + title + '\'' +
                ", endAt='" + endAt + '\'' +
                '}';
    }
}
