package com.a360vrsh.pansmartcitystory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.GoodsDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/11
 * @description:
 */
public class AttributeAdapter extends BaseQuickAdapter<GoodsDetailBean.DataBean.AttributeBean, BaseViewHolder> {


    public AttributeAdapter(@Nullable List<GoodsDetailBean.DataBean.AttributeBean> data) {
        super(R.layout.item_attribute_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsDetailBean.DataBean.AttributeBean item) {
        helper.setText(R.id.tv_name, item.getName());

        TagFlowLayout tagFlowLayout = helper.getView(R.id.tagFlowLayout);
        tagFlowLayout.setAdapter(new TagAdapter<String>(item.getValue()) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_attribute_tag,
                        tagFlowLayout, false);
                tv.setText(s);
                return tv;
            }

        });
    }
}

