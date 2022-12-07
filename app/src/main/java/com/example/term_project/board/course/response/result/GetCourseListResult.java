package com.example.term_project.board.course.response.result;

import com.google.gson.annotations.SerializedName;

public class GetCourseListResult {
    @SerializedName(value = "courseIdx") private int courseIdx;
    @SerializedName(value = "courseGrade") private int courseGrade;
    @SerializedName(value = "subjectName") private String subjectName;
    @SerializedName(value = "professor") private String professor;
    @SerializedName(value = "time") private String time;
    @SerializedName(value = "room") private String room;
    @SerializedName(value = "separation") private String separation;
    @SerializedName(value = "credit") private int credit;
    @SerializedName(value = "scoreAverage") private float scoreAverage;

    public GetCourseListResult(int courseIdx, int courseGrade, String subjectName, String professor, String time, String room, String separation, int credit, float scoreAverage) {
        this.courseIdx = courseIdx;
        this.courseGrade = courseGrade;
        this.subjectName = subjectName;
        this.professor = professor;
        this.time = time;
        this.room = room;
        this.separation = separation;
        this.credit = credit;
        this.scoreAverage = scoreAverage;
    }

    public int getCourseIdx() {
        return courseIdx;
    }

    public void setCourseIdx(int courseIdx) {
        this.courseIdx = courseIdx;
    }

    public int getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
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

    public String getSeparation() {
        return separation;
    }

    public void setSeparation(String separation) {
        this.separation = separation;
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
        return "GetCourseListResult{" +
                "courseIdx=" + courseIdx +
                ", courseGrade=" + courseGrade +
                ", subjectName='" + subjectName + '\'' +
                ", professor='" + professor + '\'' +
                ", time='" + time + '\'' +
                ", room='" + room + '\'' +
                ", separation='" + separation + '\'' +
                ", credit=" + credit +
                ", scoreAverage=" + scoreAverage +
                '}';
    }
}
