package com.example.term_project.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName="exam_sub_board",foreignKeys=@ForeignKey(entity=UserModel.class,
        parentColumns = "id",
        childColumns = "userIdx"))
public class ExamSubjectModel {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "endAt")
    private String endAt;

    @ColumnInfo(name = "createdAt")
    private String createdAt;

    @ColumnInfo(name = "updatedAt")
    private String updatedAt;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "userIdx")
    private Long userIdx;

    public ExamSubjectModel(Long id, String title, String content, String endAt, String createdAt, String updatedAt, String status, Long userIdx) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.endAt = endAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.userIdx = userIdx;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    @Override
    public String toString() {
        return "ExamSubjectModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", endAt='" + endAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", status='" + status + '\'' +
                ", userIdx=" + userIdx +
                '}';
    }
}
