package com.shakespace.template.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.shakespace.template.R;
import com.shakespace.template.base.BaseActivity;
import com.shakespace.template.fragment.FourFragment;
import com.shakespace.template.fragment.OneFragment;
import com.shakespace.template.fragment.ThreeFragment;
import com.shakespace.template.fragment.TwoFragment;
import com.shakespace.template.util.BottomNavigationViewHelper;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    @BindView(R.id.bottom_nav)
    BottomNavigationView mBottomNav;

    @BindView(R.id.container)
    FrameLayout mContainer;

    @BindView(R.id.custom_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

        Fragment mFragment = null;

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    mFragment = new OneFragment();
                    break;
                case 1:
                    mFragment = new TwoFragment();
                    break;
                case 2:
                    mFragment = new ThreeFragment();
                    break;
                case 3:
                    mFragment = new FourFragment();
                    break;
            }
            return mFragment;
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 需要theme 设置成 NoActionBar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // 关联左上角图标和侧滑菜单
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mToggle.syncState();
        mDrawerLayout.addDrawerListener(mToggle);

        BottomNavigationViewHelper.disableShiftMode(mBottomNav);
        mBottomNav.setOnNavigationItemSelectedListener(this);
        mBottomNav.setSelectedItemId(R.id.nav_one); // 设置默认
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        int index = 0;
        switch (item.getItemId()) {
            case R.id.nav_one:
                Log.e(TAG, "ONE");
                mToolbar.setTitle("ONE");
                index = 0;
                break;

            case R.id.nav_two:
                Log.e(TAG, "TWO");
                mToolbar.setTitle("TWO");
                index = 1;
                break;

            case R.id.nav_three:
                Log.e(TAG, "THREE");
                mToolbar.setTitle("THREE");
                index = 2;
                break;

            case R.id.nav_four:
                Log.e(TAG, "FOUR");
                mToolbar.setTitle("FOUR");
                index = 3;
                break;
        }
        // 判断是否持有过这个fragment 有直接返回，没有则创建
        // 该方法会调用setMenuVisibility 显示和隐藏
        fragment = (Fragment) mAdapter.instantiateItem(mContainer, index);
        // 设置为当前的frament  第二个参数没什么意义？？
        mAdapter.setPrimaryItem(mContainer, 0, fragment);
        // 提交更新
        mAdapter.finishUpdate(mContainer);
        return true;
    }
}
