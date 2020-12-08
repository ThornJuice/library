package com.a360vrsh.pansmartcitystory.adapter;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.TicketListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description:
 */
public class TicketListChildAdapter extends BaseQuickAdapter<TicketListBean.DataBean.ListBean, BaseViewHolder> {


    public TicketListChildAdapter(@Nullable List<TicketListBean.DataBean.ListBean> data) {
        super(R.layout.item_goos_detail_ticket_child, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TicketListBean.DataBean.ListBean item) {
        helper.addOnClickListener(R.id.tv_notice);
        helper.setText(R.id.tv_name, item.getName());
        if (TextUtils.equals(item.getPrice_min(), item.getPrice_max())) {
            helper.setText(R.id.tv_price, "¥ " + item.getPrice_min());
        } else {
            helper.setText(R.id.tv_price, "¥ " + item.getPrice_min() + "至¥ " + item.getPrice_max());
        }
    }

}
