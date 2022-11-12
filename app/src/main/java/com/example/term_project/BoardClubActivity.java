package com.example.term_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BoardClubActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ImageView imageView;
    ClubPageAdapter adapter;

    // array for tab labels
    private final List<String> labels = Arrays.asList("커널","가온누리","언노운","딥인트");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_club);

        // call function to initialize views
        init();

        // bind and set tabLayout to viewPager2 and set labels for every tab
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(BoardClubActivity.this);
                textView.setText(labels.get(position));
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                tab.setCustomView(textView);
            }
        }).attach();

        // 동아리 대표 사진 change event
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        imageView.setImageResource(R.drawable.kernel_logo);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.gaonnuri_logo);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.unknown_logo);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.deepint_logo);
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {} // 필수 메소드 (아직 구현x)
            @Override
            public void onTabReselected(TabLayout.Tab tab) {} // 필수 메소드 (아직 구현x)
        });
    }
    private void init() {
        // initialize imageView
        imageView = findViewById(R.id.board_club_iv_js);
        // initialize tabLayout
        tabLayout = findViewById(R.id.club_content_tb_js);
        // initialize viewPager2
        viewPager2 = findViewById(R.id.club_content_vp_js);
        // create adapter instance
        adapter = new ClubPageAdapter(this);
        // set adapter to viewPager2
        viewPager2.setAdapter(adapter);
    }
}