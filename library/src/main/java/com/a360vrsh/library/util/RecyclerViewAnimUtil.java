package com.a360vrsh.library.util;


import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

/**
 * @author: wxj
 * @date: 2020/8/19
 * @description:
 */
public class RecyclerViewAnimUtil {
    private static final RecyclerViewAnimUtil ourInstance = new RecyclerViewAnimUtil();

    public static RecyclerViewAnimUtil getInstance() {
        return ourInstance;
    }

    private RecyclerViewAnimUtil() {
    }
    /**
     * 关闭默认局部刷新动画
     */
    public void closeDefaultAnimator(RecyclerView mRvCustomer) {
        if(null==mRvCustomer)return;
        mRvCustomer.getItemAnimator().setAddDuration(0);
        mRvCustomer.getItemAnimator().setChangeDuration(0);
        mRvCustomer.getItemAnimator().setMoveDuration(0);
        mRvCustomer.getItemAnimator().setRemoveDuration(0);
        ((SimpleItemAnimator) mRvCustomer.getItemAnimator()).setSupportsChangeAnimations(false);
    }
}
