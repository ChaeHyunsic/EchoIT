package com.example.term_project.board.course.response.result;

import com.google.gson.annotations.SerializedName;

public class GetTimeTableListResult {
    @SerializedName(value = "timetableIdx") private int timetableIdx;
    @SerializedName(value = "courseGrade") private int courseGrade;
    @SerializedName(value = "subjectName") private String subjectName;
    @SerializedName(value = "professor") private String professor;
    @SerializedName(value = "time") private String time;
    @SerializedName(value = "room") private String room;
    @SerializedName(value = "separation") private String separation;
    @SerializedName(value = "credit") private int credit;

    public GetTimeTableListResult(int timetableIdx, int courseGrade, String subjectName, String professor, String time, String room, String separation, int credit) {
        this.timetableIdx = timetableIdx;
        this.courseGrade = courseGrade;
        this.subjectName = subjectName;
        this.professor = professor;
        this.time = time;
        this.room = room;
        this.separation = separation;
        this.credit = credit;
    }

    public int getTimetableIdx() {
        return timetableIdx;
    }

    public void setTimetableIdx(int timetableIdx) {
        this.timetableIdx = timetableIdx;
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
}
