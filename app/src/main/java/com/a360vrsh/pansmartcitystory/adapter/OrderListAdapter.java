package com.a360vrsh.pansmartcitystory.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.a360vrsh.library.util.RecyclerViewUtil;
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
public class OrderListAdapter extends BaseQuickAdapter<OrderListBean.DataBean, BaseViewHolder> {
    private int mShowCount = 1;

    public OrderListAdapter(@Nullable List<OrderListBean.DataBean> data) {
        super(R.layout.item_order_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderListBean.DataBean item) {
        helper.addOnClickListener(R.id.tv_one_btn, R.id.tv_two_btn);

        TextView tv_one_btn = helper.getView(R.id.tv_one_btn);
        TextView tv_two_btn = helper.getView(R.id.tv_two_btn);
        String status = item.getStatus();
        switch (status) {
            case "2":
                tv_one_btn.setText("接单");
                tv_one_btn.setVisibility(View.VISIBLE);
                break;
            case "5":
                tv_one_btn.setText("核销");
                tv_one_btn.setVisibility(View.VISIBLE);
                break;
            case "9":
                tv_one_btn.setText("发货");
                tv_one_btn.setVisibility(View.VISIBLE);
                break;
            default:
                tv_one_btn.setVisibility(View.GONE);
                break;
        }
        helper.setText(R.id.tv_order_sn, item.getSn());
        helper.setText(R.id.tv_status_title, item.getStatus_title());
        helper.setText(R.id.tv_create_date, item.getCreated_at());
        helper.setText(R.id.tv_total_price, "¥ " + item.getOrder_price());

        RecyclerView rv_goods = helper.getView(R.id.rv_goods);
        RecyclerViewUtil.setVerticalManager(mContext, rv_goods);
        List<OrderListBean.DataBean.GoodsBean> list = item.getGoods();
        helper.setText(R.id.tv_count, "共" + list.size() + "种商品");
        helper.setText(R.id.tv_count2, "共" + list.size() + "种商品");

        OrderListChildAdapter childAdapter = new OrderListChildAdapter(null, item.getStore().getStore_type());
        rv_goods.setAdapter(childAdapter);
        LinearLayout mLlExpandMore = helper.getView(R.id.ll_expend_more);
        LinearLayout mLlCloseExpand = helper.getView(R.id.ll_expend_close);

        if (list.size() > mShowCount) {

            mLlExpandMore.setVisibility(View.VISIBLE);
            mLlCloseExpand.setVisibility(View.GONE);
            childAdapter.setShowCount(mShowCount);

            mLlExpandMore.setOnClickListener(v -> {
                childAdapter.setShowCount(list.size());
                mLlCloseExpand.setVisibility(View.VISIBLE);
                mLlExpandMore.setVisibility(View.GONE);
            });
            mLlCloseExpand.setOnClickListener(v -> {
                childAdapter.setShowCount(mShowCount);
                mLlExpandMore.setVisibility(View.VISIBLE);
                mLlCloseExpand.setVisibility(View.GONE);
            });
        } else {

            mLlCloseExpand.setVisibility(View.GONE);
            mLlExpandMore.setVisibility(View.GONE);

        }
        childAdapter.setNewData(list);
    }
}
