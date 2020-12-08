package com.a360vrsh.library.adapter;

import androidx.annotation.Nullable;

import com.a360vrsh.baselibrary.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description:
 */
public class SimpleListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SimpleListAdapter(@Nullable List<String> data) {
        super(R.layout.library_item_simple_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
