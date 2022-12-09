package com.example.term_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class IsuActivity extends AppCompatActivity {
    ImageView closeIsu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isu);
        closeIsu = findViewById(R.id.isu_close_iv_js);
    }

    @Override
    protected void onResume() {
        super.onResume();
        closeIsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}