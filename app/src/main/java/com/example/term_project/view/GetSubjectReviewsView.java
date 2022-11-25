package com.example.term_project.view;

import com.example.term_project.board.evaluate_board.response.GetEvaluateSubjectResponse;
import com.example.term_project.board.evaluate_board.response.result.GetEvaluateSubjectResult;
import com.example.term_project.board.evaluate_board.response.result.GetSubjectReviewsResult;

import java.util.ArrayList;

import retrofit2.Call;

public interface GetSubjectReviewsView {
    void onGetSubjectReviewsSuccess(int code, ArrayList<GetSubjectReviewsResult> result);
    void onGetSubjectReviewsFailure(int code, String message);
}
