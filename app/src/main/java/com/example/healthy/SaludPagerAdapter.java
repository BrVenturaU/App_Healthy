package com.example.healthy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SaludPagerAdapter extends FragmentStateAdapter{
    private static final int numOfPages = 3;
    public SaludPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ProteinasFragment();
            case 1:
                return new VitaminasFragment();
            default:
                return new InformacionFragment();
        }
    }

    @Override
    public int getItemCount() {
        return numOfPages;
    }
}
