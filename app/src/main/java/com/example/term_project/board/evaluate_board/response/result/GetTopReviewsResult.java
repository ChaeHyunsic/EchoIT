package com.example.term_project.board.evaluate_board.response.result;

import com.google.gson.annotations.SerializedName;

public class GetTopReviewsResult {
    @SerializedName(value = "subjectName") private String subjectName;
    @SerializedName(value = "professor") private String professor;
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "score") private float score;

    public GetTopReviewsResult(String subjectName, String professor, String content, float score) {
        this.subjectName = subjectName;
        this.professor = professor;
        this.content = content;
        this.score = score;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
