package com.a360vrsh.pansmartcitystory.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.GoodsClassBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 左侧分类adater
 */
public class LeftClassifyAdapter extends BaseQuickAdapter<GoodsClassBean.DataBean, BaseViewHolder> {
    int position = 0;

    public LeftClassifyAdapter(@Nullable List<GoodsClassBean.DataBean> data) {
        super(R.layout.item_left_classify, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsClassBean.DataBean item) {
        helper.setText(R.id.tv_name, item.getName());

        ImageView leftImage = helper.getView(R.id.iv_left_image);

        RelativeLayout layout_root = helper.getView(R.id.layout_root);
        if (position == helper.getLayoutPosition()) {
            layout_root.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
            leftImage.setVisibility(View.VISIBLE);
        } else {
            leftImage.setVisibility(View.INVISIBLE);
            layout_root.setBackgroundColor(ContextCompat.getColor(mContext, R.color.F6F7F9));
        }

    }

    public void setPosition(int position) {
        this.position = position;
        notifyDataSetChanged();
    }
}
