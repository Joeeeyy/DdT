package com.jjoey.dynamictabs.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = ViewPagerAdapter.class.getSimpleName();

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titlesList = new ArrayList<>();

    private Context context;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(FragmentManager fm, Context ctx, ViewPager viewPager, TabLayout tabLayout) {
        super(fm);
        this.context = ctx;
        this.viewPager = viewPager;
        this.tabLayout = tabLayout;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragTab(Fragment fragment, String name){
        fragmentList.add(fragment);
        titlesList.add(name);
    }

    public void addFragLastPosition(Fragment fragment, String name){
        fragmentList.add(fragmentList.size(), fragment);
        titlesList.add(name);
    }

    public void removeFrag(int position){
        removeTab(position);
        Fragment fragment = fragmentList.get(position);
        fragmentList.remove(fragment);
        titlesList.remove(position);
        destroyFragmentView(viewPager, position, fragment);
        notifyDataSetChanged();
    }

    private void destroyFragmentView(ViewGroup container, int position, Object obj) {
        FragmentManager manager = ((Fragment) obj).getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove((Fragment) obj).commit();
    }

    private void removeTab(int position) {
        if (tabLayout.getChildCount() > 2){
            tabLayout.removeTabAt(position);
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlesList.get(position);
    }

}
