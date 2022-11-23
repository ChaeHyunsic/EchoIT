package com.example.term_project.board.exam_board.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.exam_board.response.result.GetExamSubjectsResult;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetExamSubjectResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private ArrayList<GetExamSubjectsResult> result;

    public GetExamSubjectResponse(boolean isSuccess, int code, String message, @Nullable ArrayList<GetExamSubjectsResult> result) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Nullable
    public ArrayList<GetExamSubjectsResult> getResult() {
        return result;
    }

    public void setResult(@Nullable ArrayList<GetExamSubjectsResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ExamSubjectResponse{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
