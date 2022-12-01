package com.example.term_project.board.community_board.response;

import androidx.annotation.Nullable;

import com.example.term_project.board.community_board.response.result.PostCommunityResult;
import com.google.gson.annotations.SerializedName;

public class PostCommunityResponse {
    @SerializedName(value = "isSuccess") private boolean isSuccess;
    @SerializedName(value = "code") private int code;
    @SerializedName(value = "message") private String message;

    @Nullable
    @SerializedName(value = "result")
    private PostCommunityResult result;

    public PostCommunityResponse(boolean isSuccess, int code, String message, @Nullable PostCommunityResult postCommunityResult) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.result = postCommunityResult;
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
    public PostCommunityResult getResult() {
        return result;
    }

    public void setResult(@Nullable PostCommunityResult result) {
        this.result = result;
    }
}
