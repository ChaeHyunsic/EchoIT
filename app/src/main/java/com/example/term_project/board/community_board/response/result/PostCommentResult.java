package com.example.term_project.board.community_board.response.result;

import com.google.gson.annotations.SerializedName;

public class PostCommentResult {
    @SerializedName(value = "commentIdx") private int commentIdx;
    @SerializedName(value = "content") private String content;

    public PostCommentResult(int commentIdx, String content) {
        this.commentIdx = commentIdx;
        this.content = content;
    }

    public int getCommentIdx() {
        return commentIdx;
    }

    public void setCommentIdx(int commentIdx) {
        this.commentIdx = commentIdx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
