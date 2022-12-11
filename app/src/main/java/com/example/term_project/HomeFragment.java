package com.example.term_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.term_project.board.community_board.CommunityService;
import com.example.term_project.board.community_board.response.result.GetTopCommunitiesResult;
import com.example.term_project.board.evaluate_board.EvaluateSubjectService;
import com.example.term_project.board.evaluate_board.response.result.GetTopReviewsResult;
import com.example.term_project.view.GetTopCommunitiesView;
import com.example.term_project.view.GetTopReviewsView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment implements GetTopCommunitiesView, GetTopReviewsView {
    ImageView uou,uwins,uclass,cicweb;
    TextView goCommunity,goEvaluateSub;

    TextView community_title_0,community_content_0,community_created_0,community_grade_0,community_comment_0;
    TextView community_title_1,community_content_1,community_created_1,community_grade_1,community_comment_1;
    TextView community_title_2,community_content_2,community_created_2,community_grade_2,community_comment_2;
    TextView community_title_3,community_content_3,community_created_3,community_grade_3,community_comment_3;

    RatingBar review_rating_0,review_rating_1,review_rating_2,review_rating_3;

    TextView review_subjectName_0,review_professor_0,review_content_0;
    TextView review_subjectName_1,review_professor_1,review_content_1;
    TextView review_subjectName_2,review_professor_2,review_content_2;
    TextView review_subjectName_3,review_professor_3,review_content_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initView(root);
        getTopCommunities(); // api 호출
        getTopReviews(); // api 호출
        uou = root.findViewById(R.id.home_uou_iv_js);
        // UOU 클릭
        uou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.ulsan.ac.kr/kor/Main.do"));
                startActivity(i);
            }
        });
        // UWINS 클릭
        uwins = root.findViewById(R.id.home_uwins_iv_js);
        uwins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://uwins.ulsan.ac.kr/"));
                startActivity(i);
            }
        });
        // UCLASS 클릭
        uclass = root.findViewById(R.id.home_uclass_iv_js);
        uclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://ulms.ulsan.ac.kr/"));
                startActivity(i);
            }
        });
        // CICWEB 클릭
        cicweb = root.findViewById(R.id.home_cicweb_iv_js);
        cicweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://cicweb.ulsan.ac.kr/cicweb"));
                startActivity(i);
            }
        });
        // HOT 게시물 더보기 클릭
        goCommunity = root.findViewById(R.id.communities_intent_tv_js);
        goCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CommunityBoardActivity.class);
                startActivity(intent);
            }
        });
        // 최근 강의평 더보기 클릭
        goEvaluateSub = root.findViewById(R.id.reviews_intent_tv_js);
        goEvaluateSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),EvaluateSubjectActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
    // HOT 게시물
    private void getTopCommunities(){ // API 요청 함수

        CommunityService communityService = new CommunityService();
        communityService.setGetTopCommunitiesView(this);

        communityService.getTopCommunities(); // 댓글 많은 순 정렬 후 4개의 리스트 뽑아옴.
    }

    // 최근 강의평
    private void getTopReviews(){ // API 요청 함수
        EvaluateSubjectService evaluateSubjectService = new EvaluateSubjectService();
        evaluateSubjectService.setGetTopReviewsView(this);

        evaluateSubjectService.getTopReviews(); // 최근 순 정렬 후 4개의 리스트 뽑아옴.
    }
    // 뷰 초기화
    private void initView(View root){
        // 리사이클러뷰를 쓰지 않았기 때문에 하나씩 처리함.
        community_title_0 = root.findViewById(R.id.community_title_js_0);
        community_content_0 = root.findViewById(R.id.community_content_tv_js_0);
        community_created_0 = root.findViewById(R.id.community_created_js_0);
        community_grade_0 = root.findViewById(R.id.community_grade_number_tv_js_0);
        community_comment_0 = root.findViewById(R.id.community_comment_count_tv_js_0);

        community_title_1 = root.findViewById(R.id.community_title_js_1);
        community_content_1 = root.findViewById(R.id.community_content_tv_js_1);
        community_created_1 = root.findViewById(R.id.community_created_js_1);
        community_grade_1 = root.findViewById(R.id.community_grade_number_tv_js_1);
        community_comment_1 = root.findViewById(R.id.community_comment_count_tv_js_1);

        community_title_2 = root.findViewById(R.id.community_title_js_2);
        community_content_2 = root.findViewById(R.id.community_content_tv_js_2);
        community_created_2 = root.findViewById(R.id.community_created_js_2);
        community_grade_2 = root.findViewById(R.id.community_grade_number_tv_js_2);
        community_comment_2 = root.findViewById(R.id.community_comment_count_tv_js_2);

        community_title_3 = root.findViewById(R.id.community_title_js_3);
        community_content_3 = root.findViewById(R.id.community_content_tv_js_3);
        community_created_3 = root.findViewById(R.id.community_created_js_3);
        community_grade_3 = root.findViewById(R.id.community_grade_number_tv_js_3);
        community_comment_3 = root.findViewById(R.id.community_comment_count_tv_js_3);

        review_rating_0 = root.findViewById(R.id.subject_score_rb_js_0);
        review_subjectName_0 = root.findViewById(R.id.subject_review_subjectName_tc_js_0);
        review_professor_0 = root.findViewById(R.id.subject_review_professor_tc_js_0);
        review_content_0 = root.findViewById(R.id.review_content_tv_js_0);

        review_rating_1 = root.findViewById(R.id.subject_score_rb_js_1);
        review_subjectName_1 = root.findViewById(R.id.subject_review_subjectName_tc_js_1);
        review_professor_1 = root.findViewById(R.id.subject_review_professor_tc_js_1);
        review_content_1 = root.findViewById(R.id.review_content_tv_js_1);

        review_rating_2 = root.findViewById(R.id.subject_score_rb_js_2);
        review_subjectName_2 = root.findViewById(R.id.subject_review_subjectName_tc_js_2);
        review_professor_2 = root.findViewById(R.id.subject_review_professor_tc_js_2);
        review_content_2 = root.findViewById(R.id.review_content_tv_js_2);

        review_rating_3 = root.findViewById(R.id.subject_score_rb_js_3);
        review_subjectName_3 = root.findViewById(R.id.subject_review_subjectName_tc_js_3);
        review_professor_3 = root.findViewById(R.id.subject_review_professor_tc_js_3);
        review_content_3 = root.findViewById(R.id.review_content_tv_js_3);

    }
    // API 요청 성공 시 호출하는 함수
    @Override
    public void onGetTopCommunitiesViewSuccess(int code, ArrayList<GetTopCommunitiesResult> result) {
        community_title_0.setText(result.get(0).getTitle());
        community_content_0.setText(result.get(0).getContent());
        community_created_0.setText(result.get(0).getCreatedAt());
        community_grade_0.setText(String.valueOf(result.get(0).getGrade()));
        community_comment_0.setText(String.valueOf(result.get(0).getCommentCount()));

        community_title_1.setText(result.get(1).getTitle());
        community_content_1.setText(result.get(1).getContent());
        community_created_1.setText(result.get(1).getCreatedAt());
        community_grade_1.setText(String.valueOf(result.get(1).getGrade()));
        community_comment_1.setText(String.valueOf(result.get(1).getCommentCount()));

        community_title_2.setText(result.get(2).getTitle());
        community_content_2.setText(result.get(2).getContent());
        community_created_2.setText(result.get(2).getCreatedAt());
        community_grade_2.setText(String.valueOf(result.get(2).getGrade()));
        community_comment_2.setText(String.valueOf(result.get(2).getCommentCount()));

        community_title_3.setText(result.get(3).getTitle());
        community_content_3.setText(result.get(3).getContent());
        community_created_3.setText(result.get(3).getCreatedAt());
        community_grade_3.setText(String.valueOf(result.get(3).getGrade()));
        community_comment_3.setText(String.valueOf(result.get(3).getCommentCount()));
    }
    // API 요청 실패 시 호출하는 함수
    @Override
    public void onGetTopCommunitiesViewFailure(int code, String message) {

    }

    // API 요청 성공 시 호출하는 함수
    @Override
    public void onGetTopReviewsSuccess(int code, ArrayList<GetTopReviewsResult> result) {
        review_rating_0.setRating(result.get(0).getScore());
        review_subjectName_0.setText(result.get(0).getSubjectName());
        review_professor_0.setText(result.get(0).getProfessor());
        review_content_0.setText(result.get(0).getContent());

        review_rating_1.setRating(result.get(1).getScore());
        review_subjectName_1.setText(result.get(1).getSubjectName());
        review_professor_1.setText(result.get(1).getProfessor());
        review_content_1.setText(result.get(1).getContent());

        review_rating_2.setRating(result.get(2).getScore());
        review_subjectName_2.setText(result.get(2).getSubjectName());
        review_professor_2.setText(result.get(2).getProfessor());
        review_content_2.setText(result.get(2).getContent());

        review_rating_3.setRating(result.get(3).getScore());
        review_subjectName_3.setText(result.get(3).getSubjectName());
        review_professor_3.setText(result.get(3).getProfessor());
        review_content_3.setText(result.get(3).getContent());
    }

    // API 요청 실패 시 호출하는 함수
    @Override
    public void onGetTopReviewsFailure(int code, String message) {

    }
}