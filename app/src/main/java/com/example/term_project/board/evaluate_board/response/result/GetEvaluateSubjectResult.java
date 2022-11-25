package com.example.term_project.board.evaluate_board.response.result;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class GetEvaluateSubjectResult {
    @SerializedName(value = "id") private int id;
    @SerializedName(value = "grade") private int grade;
    @SerializedName(value = "subjectName") private String subjectName;
    @SerializedName(value = "professor") private String professor;

    public GetEvaluateSubjectResult(int id, int grade, String subjectName, String professor) {
        this.id = id;
        this.grade = grade;
        this.subjectName = subjectName;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "GetEvaluateSubjectResult{" +
                "id=" + id +
                ", grade=" + grade +
                ", subjectName='" + subjectName + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
