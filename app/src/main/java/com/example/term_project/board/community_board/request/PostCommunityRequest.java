package com.example.term_project.board.community_board.request;

import com.google.gson.annotations.SerializedName;

public class PostCommunityRequest {
    @SerializedName(value = "title") private String title;
    @SerializedName(value = "content") private String content;

    public PostCommunityRequest(String title, String content) {
        this.title = title;
        this.content = content;
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
}
