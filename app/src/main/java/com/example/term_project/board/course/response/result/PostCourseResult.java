package com.example.term_project.board.course.response.result;

import com.google.gson.annotations.SerializedName;

public class PostCourseResult {
    @SerializedName(value = "courseIdx") private int courseIdx;

    public PostCourseResult(int courseIdx) {
        this.courseIdx = courseIdx;
    }

    public int getCourseIdx() {
        return courseIdx;
    }

    public void setCourseIdx(int courseIdx) {
        this.courseIdx = courseIdx;
    }
}
