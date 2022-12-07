package com.example.term_project.board.course.response.result;

import com.google.gson.annotations.SerializedName;

public class DeleteCourseResult {
    @SerializedName(value = "timetableIdx") private int timetableIdx;
    @SerializedName(value = "status") private String status;

    public DeleteCourseResult(int timetableIdx, String status) {
        this.timetableIdx = timetableIdx;
        this.status = status;
    }

    public int getTimetableIdx() {
        return timetableIdx;
    }

    public void setTimetableIdx(int timetableIdx) {
        this.timetableIdx = timetableIdx;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
