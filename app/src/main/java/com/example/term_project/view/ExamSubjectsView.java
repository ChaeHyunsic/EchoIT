package com.example.term_project.view;

import com.example.term_project.model.ExamSubjects;

import java.util.ArrayList;

public interface ExamSubjectsView {
    void onGetExamSubjectSuccess(int code, ArrayList<ExamSubjects> result);
    void onGetExamSubjectFailure(int code, String message);
}
