package com.example.aprendaingles.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabItem;

import java.util.List;

public class TabAdapter extends FragmentStateAdapter {

    private List<Fragment> tabItemList;

    public TabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, @NonNull List<Fragment> list) {
        super(fragmentManager, lifecycle);
        tabItemList = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return tabItemList.get(position);
    }

    @Override
    public int getItemCount() {
        return tabItemList.size();
    }
}
