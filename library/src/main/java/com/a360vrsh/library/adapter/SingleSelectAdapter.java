package com.a360vrsh.library.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.a360vrsh.baselibrary.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 单选列表adater
 */
public class SingleSelectAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    int position = 0;

    public SingleSelectAdapter(@Nullable List<String> data) {
        super(R.layout.library_item_single_select, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView iv_check = helper.getView(R.id.iv_check);
        if (position == helper.getLayoutPosition()) {
            iv_check.setVisibility(View.VISIBLE);
        } else {
            iv_check.setVisibility(View.GONE);
        }
    }

    public void setPosition(int position) {
        this.position = position;
        notifyDataSetChanged();
    }

    public int getPosition() {
        return position;
    }

    public String getSelectItem() {
        return getItem(position);
    }
}
