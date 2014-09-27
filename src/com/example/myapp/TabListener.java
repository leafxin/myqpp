package com.example.myapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by leafxin on 2014/9/27.
 */
public class TabListener<t extends Fragment>implements ActionBar.TabListener {
    private String tag = "TabListener" ;
    private Fragment mFragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<t> mClass;

    public TabListener(Activity activity, String tag, Class<t> clz) {
        mActivity = activity;
        mTag = tag;
        mClass = clz;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment == null) {
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            ft.add(R.id.container, mFragment, mTag);
        } else {
            ft.attach(mFragment);
        }
    }



    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (mFragment != null) {
            ft.detach(mFragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}