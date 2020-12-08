package com.a360vrsh.pansmartcitystory.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.a360vrsh.library.util.ImageLoaderUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.OrderListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description:
 */
public class OrderListChildAdapter extends BaseQuickAdapter<OrderListBean.DataBean.GoodsBean, BaseViewHolder> {
    private int mCount = 3;
    private String storeType;

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

    public OrderListChildAdapter(@Nullable List<OrderListBean.DataBean.GoodsBean> data, String storeType) {
        super(R.layout.item_order_list_child, data);
        this.storeType = storeType;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderListBean.DataBean.GoodsBean item) {
        ImageView imageView = helper.getView(R.id.iv_image);
        ImageLoaderUtil.displayImage(mContext, item.getGoods_cover_image(), imageView);
        helper.setText(R.id.tv_goods_title, item.getGoods_title());

        helper.setText(R.id.tv_goods_price, "¥ " + item.getPay_price());
        if (TextUtils.equals(storeType, "3")) {
            helper.setText(R.id.tv_goods_num, "出行人数量：" + item.getNum());
            helper.setText(R.id.tv_goods_spec, "游玩日期：" + item.getTicket_affect_date());
        } else {
            helper.setText(R.id.tv_goods_num, "数量：" + item.getNum());
            helper.setText(R.id.tv_goods_spec, item.getSpec_label());
        }
    }
}
