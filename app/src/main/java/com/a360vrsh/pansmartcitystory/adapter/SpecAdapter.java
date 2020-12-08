package com.a360vrsh.pansmartcitystory.adapter;

import androidx.annotation.Nullable;

import com.a360vrsh.library.util.StringUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.GoodsDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/11
 * @description:
 */
public class SpecAdapter extends BaseQuickAdapter<GoodsDetailBean.DataBean.SpecsBean, BaseViewHolder> {


    public SpecAdapter(@Nullable List<GoodsDetailBean.DataBean.SpecsBean> data) {
        super(R.layout.item_goods_spec_table, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsDetailBean.DataBean.SpecsBean item) {

        helper.setText(R.id.tv_name, StringUtil.arrayToStringBySplit(item.getName(), "*"));
        helper.setText(R.id.tv_sale_price, item.getPrice());
        helper.setText(R.id.tv_market_price, item.getPrice_origin());
        helper.setText(R.id.tv_price_cost, item.getPrice_cost());

    }
}

