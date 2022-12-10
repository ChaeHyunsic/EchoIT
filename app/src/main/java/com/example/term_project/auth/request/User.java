package com.example.term_project.auth.request;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName(value = "id") private String id;
    @SerializedName(value = "pw") private String password;
    @SerializedName(value = "nickName") private String nickName;
    @SerializedName(value = "department") private String department;
    @SerializedName(value = "grade") private int grade;

    public User(String id, String password, String nickName, String department, int grade) {
        this.id = id;
        this.password = password;
        this.nickName = nickName;
        this.department = department;
        this.grade = grade;
    }
    public User(String id, String password){
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", department='" + department + '\'' +
                ", grade=" + grade +
                '}';
    }
}

