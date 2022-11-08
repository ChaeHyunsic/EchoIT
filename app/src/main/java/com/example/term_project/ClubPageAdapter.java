package com.example.term_project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ClubPageAdapter extends FragmentStateAdapter {
    private final int tabPageCount = 4;
    public ClubPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new KernelFragment();
            case 1:
                return new GaonnuriFragment();
            case 2:
                return new UnknownFragment();
            case 3:
                return new DeepIntFragment();
        }
        return new KernelFragment();
    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    @Override
    public int getItemCount() {
        return tabPageCount;
    }
}
