package com.example.term_project.auth.response.result;

import com.google.gson.annotations.SerializedName;

public class LoginResult {
    @SerializedName(value = "userIdx") private int userIdx;
    @SerializedName(value = "jwt") private String jwt;

    public LoginResult(int userIdx, String jwt) {
        this.userIdx = userIdx;
        this.jwt = jwt;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "ResultLogin{" +
                "userIdx=" + userIdx +
                ", jwt='" + jwt + '\'' +
                '}';
    }
}
