package com.a360vrsh.pansmartcitystory.adapter;

import androidx.annotation.Nullable;

import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.RefundDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 退款详情页-商品列表adater
 */
public class RefundDetailGoodsAdapter extends BaseQuickAdapter<RefundDetailBean.DataBean.GoodsBean, BaseViewHolder> {
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

    public RefundDetailGoodsAdapter(@Nullable List<RefundDetailBean.DataBean.GoodsBean> data) {
        super(R.layout.item_refund_detail_goods, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RefundDetailBean.DataBean.GoodsBean item) {

        helper.setText(R.id.tv_goods_title, item.getGoods_title());
        helper.setText(R.id.tv_goods_num, "x" + item.getGoods_num());
        helper.setText(R.id.tv_goods_price, item.getPrice());
    }

}
