package com.example.term_project.view;

import com.example.term_project.board.evaluate_board.response.result.GetTopReviewsResult;

import java.util.ArrayList;

public interface GetTopReviewsView {
    void onGetTopReviewsSuccess(int code, ArrayList<GetTopReviewsResult> result);
    void onGetTopReviewsFailure(int code, String message);
}
