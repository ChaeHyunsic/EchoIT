package com.example.term_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private MapFragment mapFragment;
    private NotifyFragment notifyFragment;
    private ScheduleFragment scheduleFragment;
    private BoardFragment boardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigation();
    }

    private void initBottomNavigation(){ // 뷰 초기화 부분 -> onCreate에 넣어주자.
        homeFragment = new HomeFragment();
        mapFragment = new MapFragment();
        notifyFragment = new NotifyFragment();
        scheduleFragment = new ScheduleFragment();
        boardFragment = new BoardFragment();

        BottomNavigationView bottomNavigationView = findViewById(R.id.main_bnv_js); // 처음화면
        getSupportFragmentManager().beginTransaction().add(R.id.main_frm_js, homeFragment).commitAllowingStateLoss(); // FrameLayout에 fragment_home.xml 띄우기

        //바텀 네비게이션 뷰 안의 아이템 설정
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){ // item 클릭 시 id값을 가져와서 FrameLayout에 fragment_xxx.xml띄우기
                    case R.id.homeFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm_js,homeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.mapFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm_js,mapFragment).commitAllowingStateLoss();
                        break;
                    case R.id.notifyFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm_js,notifyFragment).commitAllowingStateLoss();
                        break;
                    case R.id.scheduleFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm_js,scheduleFragment).commitAllowingStateLoss();
                        break;
                    case R.id.boardFragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frm_js,boardFragment).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });
    }
}