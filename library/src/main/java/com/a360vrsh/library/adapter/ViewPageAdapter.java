package com.a360vrsh.library.adapter;


import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/10/9
 * @description:
 */
public class ViewPageAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;


    public ViewPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // 覆写destroyItem并且空实现,这样每个Fragment中的视图就不会被销毁
        super.destroyItem(container, position, object);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }


}
