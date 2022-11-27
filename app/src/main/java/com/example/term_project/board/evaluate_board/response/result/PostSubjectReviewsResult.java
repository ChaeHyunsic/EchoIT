package com.example.term_project.board.evaluate_board.response.result;

import com.google.gson.annotations.SerializedName;

public class PostSubjectReviewsResult {
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "score") private float score;

    public PostSubjectReviewsResult(String content, float score) {
        this.content = content;
        this.score = score;
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

    @Override
    public String toString() {
        return "PostSubjectReviewsResult{" +
                "content='" + content + '\'' +
                ", score=" + score +
                '}';
    }
}
