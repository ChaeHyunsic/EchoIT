package com.example.term_project.board.evaluate_board.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.evaluate_board.response.result.GetSubjectInfoResult;
import com.google.gson.annotations.SerializedName;

public class GetSubjectInfoResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private GetSubjectInfoResult result;

    public GetSubjectInfoResponse(boolean isSuccess, int code, String message, @Nullable GetSubjectInfoResult result) {
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
    public GetSubjectInfoResult getResult() {
        return result;
    }

    public void setResult(@Nullable GetSubjectInfoResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GetSubjectInfoResponse{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
