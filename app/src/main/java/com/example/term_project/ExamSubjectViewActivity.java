package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ExamSubjectViewActivity extends AppCompatActivity {
    TextView title,content,endAt;
    ImageView close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject_view);
        initview();
    }
    private void initview(){
        title = findViewById(R.id.title_tv_create_js);
        content = findViewById(R.id.content_tv_create_js);
        endAt = findViewById(R.id.deadline_check_tv_js);
        close = findViewById(R.id.exam_sub_close_iv_js);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getIntent().hasExtra("titleView") && getIntent().hasExtra("contentView") && getIntent().hasExtra("endAtView")){
            Log.d("INTENT-VIEWMODE", getIntent().getStringExtra("titleView")+" "
                    +getIntent().getStringExtra("contentView")+" "
                    +getIntent().getStringExtra("endAtView"));
            title.setText(getIntent().getStringExtra("titleView"));
            content.setText(getIntent().getStringExtra("contentView"));
            endAt.setText(getIntent().getStringExtra("endAtView"));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}