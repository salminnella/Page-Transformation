package com.salmin.onboardingdemo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IntroAdapter extends FragmentPagerAdapter {


    public static int PURPLE = -3644315;
    public static int GREEN = -3618715;

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(PURPLE, position); // red
//				return IntroFragment.newInstance(Color.parseColor("#FF0000"), position); // red
//				return IntroFragment.newInstance(Color.parseColor("#03A9F4"), position); // blue
            default:
                return IntroFragment.newInstance(GREEN, position); // gray
//				return IntroFragment.newInstance(Color.parseColor("#A9A9A9"), position); // gray
//				return IntroFragment.newInstance(Color.parseColor("#4CAF50"), position); // green
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
