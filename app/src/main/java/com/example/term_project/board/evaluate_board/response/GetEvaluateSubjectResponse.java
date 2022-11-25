package com.example.term_project.board.evaluate_board.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetEvaluateSubjectResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private ArrayList<GetEvaluateSubjectResult> result;

    public GetEvaluateSubjectResponse(boolean isSuccess, int code, String message, @Nullable ArrayList<GetEvaluateSubjectResult> result) {
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
    public ArrayList<GetEvaluateSubjectResult> getResult() {
        return result;
    }

    public void setResult(@Nullable ArrayList<GetEvaluateSubjectResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GetEvaluateSubjectResponse{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
