package com.example.term_project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;

public class BoardFragment extends Fragment {
    MaterialCardView[] materialCardView = new MaterialCardView[8];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_board, container, false);

        materialCardView[7] = root.findViewById(R.id.board_card_club_mcv_dong_gy);
        materialCardView[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),BoardClubActivity.class);
                startActivity(intent);
            }
        });
        materialCardView[1] = root.findViewById(R.id.board_card_club_mcv_homework_gy);
        materialCardView[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ExamSubjectActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}