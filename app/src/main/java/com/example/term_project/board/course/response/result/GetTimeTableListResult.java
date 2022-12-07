package com.example.term_project.board.course.response.result;

import com.google.gson.annotations.SerializedName;

public class GetTimeTableListResult {
    @SerializedName(value = "timetableIdx") private int timetableIdx;
    @SerializedName(value = "subjectName") private String subjectName;
    @SerializedName(value = "room") private String room;
    @SerializedName(value = "time") private String time;

    public GetTimeTableListResult(int timetableIdx, String subjectName, String room, String time) {
        this.timetableIdx = timetableIdx;
        this.subjectName = subjectName;
        this.room = room;
        this.time = time;
    }

    public int getTimetableIdx() {
        return timetableIdx;
    }

    public void setTimetableIdx(int timetableIdx) {
        this.timetableIdx = timetableIdx;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
