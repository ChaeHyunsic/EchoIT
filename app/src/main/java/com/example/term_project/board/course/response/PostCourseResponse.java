package com.example.term_project.board.course.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.course.response.result.PostCourseResult;
import com.google.gson.annotations.SerializedName;

public class PostCourseResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private PostCourseResult result;

    public PostCourseResponse(boolean isSuccess, int code, String message, @Nullable PostCourseResult result) {
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
    public PostCourseResult getResult() {
        return result;
    }

    public void setResult(@Nullable PostCourseResult result) {
        this.result = result;
    }
}
