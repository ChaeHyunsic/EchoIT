package com.example.term_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class NoticeActivity extends AppCompatActivity {
    private ImageView closeNotice;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    NoticePageAdapter adapter;

    private final List<String> labels = Arrays.asList("울산대뉴스","학부공지","전공소식","채용공고");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        // call function to initialize views
        init();

        closeNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // bind and set tabLayout to viewPager2 and set labels for every tab
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(NoticeActivity.this);
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
                        System.out.println("0");
                        break;
                    case 1:
                        System.out.println("1");
                        break;
                    case 2:
                        System.out.println("2");
                        break;
                    case 3:
                        System.out.println("3");
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
        // initialize tabLayout
        tabLayout = findViewById(R.id.notice_tb_ch);
        // initialize viewPager2
        viewPager2 = findViewById(R.id.notice_vp_ch);
        // create adapter instance
        adapter = new NoticePageAdapter(this);
        // set adapter to viewPager2
        viewPager2.setAdapter(adapter);

        closeNotice = findViewById(R.id.notice_board_close_iv_js);
    }
}