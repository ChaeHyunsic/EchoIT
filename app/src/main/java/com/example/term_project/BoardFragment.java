package com.example.term_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;

public class BoardFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_board, container, false);

        // get club cardview
        MaterialCardView materialCardView_club = root.findViewById(R.id.board_card_club_mcv_dong_gy);
        materialCardView_club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BoardClubActivity.class);
                startActivity(intent);
            }
        });

        // get notice cardview
        MaterialCardView materialCardView_notice = root.findViewById(R.id.board_card_club_mcv_exam_gy);
        materialCardView_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),NoticeActivity.class);
                startActivity(intent);
            }
        });

        // get exam-subject cardview
        MaterialCardView materialCardView_exam_subject = root.findViewById(R.id.board_card_club_mcv_homework_gy);
        materialCardView_exam_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ExamSubjectActivity.class);
                startActivity(intent);
            }
        });
        // get evaluate-subject cardview
        MaterialCardView materialCardView_evaluate_subject = root.findViewById(R.id.board_card_club_mcv_pyeong_gy);
        materialCardView_evaluate_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),EvaluateSubjectActivity.class);
                startActivity(intent);
            }
        });
        // get evaluate-subject cardview
        MaterialCardView materialCardView_community = root.findViewById(R.id.board_card_club_mcv_community_gy);
        materialCardView_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CommunityBoardActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}