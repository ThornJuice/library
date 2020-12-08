package com.a360vrsh.pansmartcitystory.adapter;

import androidx.annotation.Nullable;

import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.GoodsClassBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description:
 */
public class AddGoodsClassListAdapter extends BaseQuickAdapter<GoodsClassBean.DataBean, BaseViewHolder> {


    public AddGoodsClassListAdapter(@Nullable List<GoodsClassBean.DataBean> data) {
        super(R.layout.item_add_goods_class_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsClassBean.DataBean item) {
        helper.addOnClickListener(R.id.tv_edit, R.id.tv_delete);
        helper.setText(R.id.tv_name, item.getName());

    }
}
