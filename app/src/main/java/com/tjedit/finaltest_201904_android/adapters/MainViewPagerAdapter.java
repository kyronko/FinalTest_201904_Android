package com.tjedit.finaltest_201904_android.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tjedit.finaltest_201904_android.fragments.MyProfileFragment;
import com.tjedit.finaltest_201904_android.fragments.NoticeListFragment;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    MyProfileFragment frag1 = null;
    NoticeListFragment frag2 = null;
    int mNumOfTabs;



    public MainViewPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fr = null;

        if (position == 0) {
            if (frag1 == null) {
                frag1 = new MyProfileFragment();
            }

            fr = frag1;
        }
        else if (position == 1) {
            if (frag2 == null) {
                frag2 = new NoticeListFragment();
            }

            fr = frag2;
        }
        return fr;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}