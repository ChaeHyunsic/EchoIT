package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ExamSubjectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject);

        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<15;i++){
            list.add(String.format("TEXT %d",i));
        }

        RecyclerView recyclerView = findViewById(R.id.exam_sub_rv_js);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ExamSubjectAdapter adapter = new ExamSubjectAdapter(list);
        recyclerView.setAdapter(adapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.plus_item_fab_js);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExamSubjectActivity.this,ExamSubjectEditActivity.class);
                startActivity(intent);
            }
        });
    }


}