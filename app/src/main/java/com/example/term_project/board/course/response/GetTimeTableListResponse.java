package com.example.term_project.board.course.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.course.response.result.GetTimeTableListResult;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetTimeTableListResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private ArrayList<GetTimeTableListResult> result;

    public GetTimeTableListResponse(boolean isSuccess, int code, String message, @Nullable ArrayList<GetTimeTableListResult> result) {
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
    public ArrayList<GetTimeTableListResult> getResult() {
        return result;
    }

    public void setResult(@Nullable ArrayList<GetTimeTableListResult> result) {
        this.result = result;
    }
}
