package com.example.term_project.board.exam_board.response.result;

import com.google.gson.annotations.SerializedName;

public class DeleteExamSubjectResult {
    @SerializedName(value = "listIdx") private int listIdx;
    @SerializedName(value = "status") private String status;

    public DeleteExamSubjectResult(int listIdx, String status) {
        this.listIdx = listIdx;
        this.status = status;
    }

    public int getListIdx() {
        return listIdx;
    }

    public void setListIdx(int listIdx) {
        this.listIdx = listIdx;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeleteExamSubjectResult{" +
                "listIdx=" + listIdx +
                ", status='" + status + '\'' +
                '}';
    }
}
