package com.example.term_project.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

@Entity(tableName="user")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "userID")
    private String userID;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "nickname")
    private String nickname;

    @ColumnInfo(name = "department")
    private String department;

    @ColumnInfo(name = "grade")
    private int grade;

    @ColumnInfo(name = "createdAt")
    private String createdAt;

    @ColumnInfo(name = "updatedAt")
    private String updatedAt;

    @ColumnInfo(name = "status")
    private String status;

    public UserModel(String userID, String password, String nickname, String department, int grade, String createdAt, String updatedAt, String status) {
        this.userID = userID;
        this.password = password;
        this.nickname = nickname;
        this.department = department;
        this.grade = grade;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
