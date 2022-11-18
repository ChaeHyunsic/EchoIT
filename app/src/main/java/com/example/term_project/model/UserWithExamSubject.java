package com.example.term_project.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithExamSubject {
    @Embedded UserModel userModel;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    List<ExamSubjectModel> examSubjectModelList;

    public UserWithExamSubject(UserModel userModel, List<ExamSubjectModel> examSubjectModelList) {
        this.userModel = userModel;
        this.examSubjectModelList = examSubjectModelList;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public List<ExamSubjectModel> getExamSubjectModelList() {
        return examSubjectModelList;
    }

    public void setExamSubjectModelList(List<ExamSubjectModel> examSubjectModelList) {
        this.examSubjectModelList = examSubjectModelList;
    }

    @Override
    public String toString() {
        return "UserWithExamSubject{" +
                "userModel=" + userModel +
                ", examSubjectModelList=" + examSubjectModelList +
                '}';
    }
}
