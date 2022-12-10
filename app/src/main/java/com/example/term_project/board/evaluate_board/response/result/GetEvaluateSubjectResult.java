package com.example.term_project.board.evaluate_board.response.result;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class GetEvaluateSubjectResult {
    @SerializedName(value = "id") private int id;
    @SerializedName(value = "subjectName") private String subjectName;
    @SerializedName(value = "professor") private String professor;
    @SerializedName(value = "separation") private String separation;
    @SerializedName(value = "grade") private int grade;
    @SerializedName(value = "time") private String time;
    @SerializedName(value = "room") private String room;
    @SerializedName(value = "credit") private int credit;
    @SerializedName(value = "scoreAverage") private float scoreAverage;

    public GetEvaluateSubjectResult(int id, String subjectName, String professor, String separation, int grade, String time, String room, int credit, float scoreAverage) {
        this.id = id;
        this.subjectName = subjectName;
        this.professor = professor;
        this.separation = separation;
        this.grade = grade;
        this.time = time;
        this.room = room;
        this.credit = credit;
        this.scoreAverage = scoreAverage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSeparation() {
        return separation;
    }

    public void setSeparation(String separation) {
        this.separation = separation;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public float getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(float scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    @Override
    public String toString() {
        return "GetEvaluateSubjectResult{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", professor='" + professor + '\'' +
                ", separation='" + separation + '\'' +
                ", grade=" + grade +
                ", time='" + time + '\'' +
                ", room='" + room + '\'' +
                ", credit=" + credit +
                ", scoreAverage=" + scoreAverage +
                '}';
    }
}
