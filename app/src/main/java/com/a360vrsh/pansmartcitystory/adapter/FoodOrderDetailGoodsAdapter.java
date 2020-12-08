package com.a360vrsh.pansmartcitystory.adapter;

import androidx.annotation.Nullable;

import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.FoodOrderDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 美食订单详情页-商品列表adater
 */
public class FoodOrderDetailGoodsAdapter extends BaseQuickAdapter<FoodOrderDetailBean.DataBean.GoodsBean, BaseViewHolder> {
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

    public FoodOrderDetailGoodsAdapter(@Nullable List<FoodOrderDetailBean.DataBean.GoodsBean> data) {
        super(R.layout.item_refund_detail_goods, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodOrderDetailBean.DataBean.GoodsBean item) {

        helper.setText(R.id.tv_goods_title, item.getGoods_title());
        helper.setText(R.id.tv_goods_num, "x" + item.getNum());
        helper.setText(R.id.tv_goods_price, item.getPrice());
    }

}
