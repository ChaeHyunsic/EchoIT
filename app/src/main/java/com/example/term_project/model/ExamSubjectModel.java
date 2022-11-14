package com.example.term_project.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Timestamp;

@Entity(tableName="exam_sub_board")
public class ExamSubjectModel {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "endAt")
    private Timestamp endAt;

    @ColumnInfo(name = "createdAt")
    private Timestamp createdAt;

    @ColumnInfo(name = "updatedAt")
    private Timestamp updatedAt;

    @ColumnInfo(name = "status")
    private String status;
}
