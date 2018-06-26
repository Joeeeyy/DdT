package com.jjoey.dynamictabs.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Select;
import com.jjoey.dynamictabs.R;
import com.jjoey.dynamictabs.models.Customize;
import com.jjoey.dynamictabs.utils.Constants;
import com.jjoey.dynamictabs.utils.ViewPagerAdapter;

public class ParentFragment extends Fragment {

    private static final String TAG = ParentFragment.class.getSimpleName();

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private static int selPosition;
    private Customize customize = null;

    public ParentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parent, container, false);

        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewPager);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        adapter = new ViewPagerAdapter(getFragmentManager(), getActivity(), viewPager, tabLayout);

        adapter.addFragTab(new Top30Frag(), Constants.Top30);

        customize = new Select()
                .from(Customize.class)
                .where("tabName=?", Constants.NATURE)
                .executeSingle();
        if (customize != null) {
            Log.d(TAG, "Nature from db:\t" + customize.tabName);
            adapter.addFragTab(new NatureFrag(), Constants.NATURE);
            adapter.notifyDataSetChanged();
        }

        customize = new Select()
                .from(Customize.class)
                .where("tabName=?", Constants.SPACE)
                .executeSingle();
        if (customize != null) {
            Log.d(TAG, "Space from db:\t" + customize.tabName);
            adapter.addFragTab(new SpaceFrag(), Constants.SPACE);
            adapter.notifyDataSetChanged();
        }

        customize = new Select()
                .from(Customize.class)
                .where("tabName=?", Constants.SEASONS)
                .executeSingle();
        if (customize != null) {
            Log.d(TAG, "Space from db:\t" + customize.tabName);
            adapter.addFragTab(new SeasonsFrag(), Constants.SEASONS);
            adapter.notifyDataSetChanged();
        }

        customize = new Select()
                .from(Customize.class)
                .where("tabName=?", Constants.ART)
                .executeSingle();
        if (customize != null) {
            Log.d(TAG, "Art from db:\t" + customize.tabName);
            adapter.addFragTab(new ArtFrag(), Constants.ART);
            adapter.notifyDataSetChanged();
        }

//        if (tabLayout.getChildAt(1).equals(Constants.NATURE)){
//            Log.d(TAG, "Nature Tab Index At Position:\t" + 1);
//        } else {
//            Log.d(TAG, "Unknown Index");
//        }

//        if (tabLayout.getTabAt(1).getText().equals(Constants.NATURE)){
//            Log.d(TAG, "Nature Tab Index At Position:\t" + 1);
//        } else {
//            Log.d(TAG, "Unknown Index");
//        }

        adapter.addFragLastPosition(new PrefsFrag(), Constants.PREFS);
        viewPager.setAdapter(adapter);

        addEvents();

        for (int i = 0; i < tabLayout.getChildCount(); i++){
            selPosition = viewPager.getCurrentItem();

            Log.d(TAG, "Sel Position:\t" + selPosition);
            Log.d(TAG, "TabsCount:\t" + tabLayout.getChildCount());

            if (tabLayout.getTabAt(i).getText().equals(Constants.NATURE)){
                Log.d(TAG, "Nature Tab Position:\t" + i);
            }
        }

        return view;
    }

    private void addEvents() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
                selPosition = viewPager.getCurrentItem();
                Log.d(TAG, "Selected Tab Position:\t" + tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d(TAG, "Un-Selected Tab Position:\t" + tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), true);
                selPosition = viewPager.getCurrentItem();
                Log.d(TAG, "Re-Selected Tab Position:\t" + tab.getPosition());
            }
        });
    }

}
