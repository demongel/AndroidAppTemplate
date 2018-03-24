package com.shakespace.template.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shakespace.template.fragment.BlankFragment;

/**
 * Created by shakespace on 2018/3/24.
 */

public class OneFragmentPageAdapter extends FragmentPagerAdapter {

    private  String [] mTitles;
    public OneFragmentPageAdapter(FragmentManager fm,String [] titles) {
        super(fm);
        this.mTitles = titles;
    }

    Fragment mFragment = null;

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                mFragment = new BlankFragment();
                break;
            case 1:
                mFragment = new BlankFragment();
                break;
            case 2:
                mFragment = new BlankFragment();
                break;
        }
        return mFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}
