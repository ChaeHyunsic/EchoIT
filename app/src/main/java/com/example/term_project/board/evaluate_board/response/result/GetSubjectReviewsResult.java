package com.example.term_project.board.evaluate_board.response.result;

import com.google.gson.annotations.SerializedName;

public class GetSubjectReviewsResult {
    @SerializedName(value = "nickName") private String nickName;
    @SerializedName(value = "content") private String content;
    @SerializedName(value = "score") private float score;

    public GetSubjectReviewsResult(String nickName, String content, float score) {
        this.nickName = nickName;
        this.content = content;
        this.score = score;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
        return "GetSubjectReviewsResult{" +
                "nickName='" + nickName + '\'' +
                ", content='" + content + '\'' +
                ", score=" + score +
                '}';
    }
}
