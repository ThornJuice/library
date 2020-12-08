package com.a360vrsh.pansmartcitystory.adapter;

import androidx.annotation.Nullable;


import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.TravelOrderDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 旅游订单详情-出行人列表
 */

public class TravelOrderDetailTouristAdapter extends BaseQuickAdapter<TravelOrderDetailBean.DataBean.InfoBean, BaseViewHolder> {
    private int mCount = 3;

    /**
     * 设置显示的条数
     */
    public void setShowCount(int count) {
        mCount = count;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return Math.min(super.getItemCount(), mCount);
    }

    public TravelOrderDetailTouristAdapter(@Nullable List<TravelOrderDetailBean.DataBean.InfoBean> data) {
        super(R.layout.item_order_detail_tourist, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TravelOrderDetailBean.DataBean.InfoBean item) {
        helper.setText(R.id.tv_tourist_name, item.getTourist_name());
        helper.setText(R.id.tv_tourist_phone, item.getTourist_phone());
//        String fullIdCard = item.getTourist_idcard();
//        StringBuilder stringBuilder = new StringBuilder(fullIdCard);
//        if (fullIdCard.length() == 18) {
//            stringBuilder.replace(4, stringBuilder.length() - 2, "************");
//        }
//        helper.setText(R.id.tv_tourist_id, stringBuilder.toString());

        helper.setText(R.id.tv_tourist_id,item.getTourist_idcard());
    }

}