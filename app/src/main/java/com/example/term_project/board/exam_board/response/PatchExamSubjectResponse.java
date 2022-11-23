package com.example.term_project.board.exam_board.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.exam_board.response.result.PatchExamSubjectResult;
import com.google.gson.annotations.SerializedName;

public class PatchExamSubjectResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private PatchExamSubjectResult result;

    public PatchExamSubjectResponse(boolean isSuccess, int code, String message, @Nullable PatchExamSubjectResult result) {
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
    public PatchExamSubjectResult getResult() {
        return result;
    }

    public void setResult(@Nullable PatchExamSubjectResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PatchExamSubjectResponse{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
