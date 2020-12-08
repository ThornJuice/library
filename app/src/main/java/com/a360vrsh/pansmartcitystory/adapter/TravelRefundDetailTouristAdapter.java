package com.a360vrsh.pansmartcitystory.adapter;

import androidx.annotation.Nullable;

import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.RefundDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 售后详情-出行人列表
 */

public class TravelRefundDetailTouristAdapter extends BaseQuickAdapter<RefundDetailBean.DataBean.InfoBean, BaseViewHolder> {
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

    public TravelRefundDetailTouristAdapter(@Nullable List<RefundDetailBean.DataBean.InfoBean> data) {
        super(R.layout.item_order_detail_tourist, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RefundDetailBean.DataBean.InfoBean item) {
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