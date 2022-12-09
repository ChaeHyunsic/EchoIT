package com.example.term_project.auth.response.result;

import com.google.gson.annotations.SerializedName;

public class LoginResult {
    @SerializedName(value = "userIdx") private int userIdx;
    @SerializedName(value = "jwt") private String jwt;
    @SerializedName(value = "grade") private int grade;
    @SerializedName(value = "department") private String department;
    @SerializedName(value = "nickName") private String nickName;

    public LoginResult(int userIdx, String jwt, int grade, String department, String nickName) {
        this.userIdx = userIdx;
        this.jwt = jwt;
        this.grade = grade;
        this.department = department;
        this.nickName = nickName;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
