package com.example.term_project.board.exam_board.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.exam_board.response.result.PostExamSubjectResult;
import com.google.gson.annotations.SerializedName;

public class PostExamSubjectResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private PostExamSubjectResult result;

    public PostExamSubjectResponse(boolean isSuccess, int code, String message, @Nullable PostExamSubjectResult result) {
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
    public PostExamSubjectResult getResult() {
        return result;
    }

    public void setResult(@Nullable PostExamSubjectResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PostExamSubjectResponse{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
