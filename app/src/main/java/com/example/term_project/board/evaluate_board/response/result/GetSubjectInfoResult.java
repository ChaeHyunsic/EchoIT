package com.example.term_project.board.evaluate_board.response.result;

import com.google.gson.annotations.SerializedName;

public class GetSubjectInfoResult {
    @SerializedName(value = "id") private int id;
    @SerializedName(value = "scoreAverage") private float scoreAverage;

    public GetSubjectInfoResult(int id, float scoreAverage) {
        this.id = id;
        this.scoreAverage = scoreAverage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(float scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    @Override
    public String toString() {
        return "GetSubjectInfoResult{" +
                "id=" + id +
                ", scoreAverage=" + scoreAverage +
                '}';
    }
}
