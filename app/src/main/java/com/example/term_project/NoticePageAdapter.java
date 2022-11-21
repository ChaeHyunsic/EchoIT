package com.example.term_project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NoticePageAdapter extends FragmentStateAdapter {
    public NoticePageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new NoticeNewsFragment();
            case 1:
                return new NoticeItFragment();
            case 2:
                return new NoticeMajorFragment();
            case 3:
                return new NoticeJobFragment();
        }
        return new KernelFragment();
    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    @Override
    public int getItemCount() {
        return 4;
    }
}
