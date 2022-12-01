package com.example.term_project.auth.response.result;

import com.google.gson.annotations.SerializedName;

public class LoginResult {
    @SerializedName(value = "userIdx") private int userIdx;
    @SerializedName(value = "jwt") private String jwt;
    @SerializedName(value = "grade") private int grade;

    public LoginResult(int userIdx, String jwt, int grade) {
        this.userIdx = userIdx;
        this.jwt = jwt;
        this.grade = grade;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
