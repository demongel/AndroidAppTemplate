package com.shakespace.template.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shakespace.template.R;
import com.shakespace.template.adapter.OneFragmentPageAdapter;
import com.shakespace.template.base.BaseFragment;

import butterknife.BindArray;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends BaseFragment {

    private static final String TAG = "OneFragment";
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    private OneFragmentPageAdapter mAdapter;

    @BindArray(R.array.titles)
    String[] mTitles;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    protected void initListener(View view) {

        //   不能用内部类创建  getChildFragmentManager 需要在attach后使用
        mAdapter = new OneFragmentPageAdapter(getChildFragmentManager(),mTitles);

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }


}
