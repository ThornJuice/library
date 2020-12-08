package com.a360vrsh.library.util;

import android.content.Context;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;


public class RecyclerViewUtil {
    /**
     * 垂直列表
     *
     * @param context          Context
     * @param recycleView      RecyclerView
     * @param baseQuickAdapter BaseQuickAdapter
     */
    public static void setVerticalRecycleView(Context context, RecyclerView recycleView, BaseQuickAdapter baseQuickAdapter) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(baseQuickAdapter);
    }

    /**
     * 宫格列表
     *
     * @param context          Context
     * @param recycleView      RecyclerView
     * @param baseQuickAdapter BaseQuickAdapter
     */
    public static void setGridRecycleView(Context context, RecyclerView recycleView, int spanCount, BaseQuickAdapter baseQuickAdapter) {
        GridLayoutManager manager = new GridLayoutManager(context, spanCount);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(baseQuickAdapter);
    }

    /**
     * 水平列表
     *
     * @param context          Context
     * @param recycleView      RecyclerView
     * @param baseQuickAdapter BaseQuickAdapter
     */
    public static void setHorizontalRecycleView(Context context, RecyclerView recycleView, BaseQuickAdapter baseQuickAdapter) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(baseQuickAdapter);
    }

//    /**
//     * 分页列表使用
//     *
//     * @param context          Context
//     * @param recycleView      RecyclerView
//     * @param baseQuickAdapter BaseQuickAdapter
//     */
//    public static void setVerticalRecycleViewByPage(Context context, RecyclerView recycleView, BaseQuickAdapter baseQuickAdapter) {
//        LinearLayoutManager manager = new LinearLayoutManager(context);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
//        recycleView.setLayoutManager(manager);
//        recycleView.setAdapter(baseQuickAdapter);
//        baseQuickAdapter.setEnableLoadMore(true);
//        baseQuickAdapter.setEmptyView(R.layout.layout_empty_list, recycleView);
//        baseQuickAdapter.disableLoadMoreIfNotFullPage(recycleView);
//        baseQuickAdapter.setLoadMoreView(new CustomLoadMoreView());
//    }

    public static void setGridManager(Context context, RecyclerView recycleView, int spanCount) {
        GridLayoutManager manager = new GridLayoutManager(context, spanCount);
        recycleView.setLayoutManager(manager);
    }

    public static void setHorizontalManager(Context context, RecyclerView recycleView) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleView.setLayoutManager(manager);
    }

    public static void setVerticalManager(Context context, RecyclerView recycleView) {
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(manager);
    }
}
