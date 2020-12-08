package com.a360vrsh.pansmartcitystory.adapter;

import androidx.annotation.Nullable;

import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.RedPacketListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description:
 */
public class RedPacketListAdapter extends BaseQuickAdapter<RedPacketListBean.DataBean, BaseViewHolder> {
    public RedPacketListAdapter(@Nullable List<RedPacketListBean.DataBean> data) {
        super(R.layout.item_red_packet, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RedPacketListBean.DataBean item) {
        helper.setText(R.id.tv_title, item.getSlogan());
        helper.setText(R.id.tv_number_total, "数量" + item.getNumber_total());
        helper.setText(R.id.tv_number_receive, "已有" + item.getNumber_receive() + "人领取");
        helper.setText(R.id.tv_money, "¥ " + item.getMoney());

    }
}
