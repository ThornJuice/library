package com.a360vrsh.pansmartcitystory.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.a360vrsh.library.util.RecyclerViewUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.RefundListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description: 退款状态:1=审核中2=同意退款3=退款成功-1=拒绝退款
 */
public class RefundListAdapter extends BaseQuickAdapter<RefundListBean.DataBean, BaseViewHolder> {
    private int mShowCount = 1;

    public RefundListAdapter(@Nullable List<RefundListBean.DataBean> data) {
        super(R.layout.item_refund_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RefundListBean.DataBean item) {
        helper.addOnClickListener(R.id.tv_one_btn, R.id.tv_two_btn);
        helper.setText(R.id.tv_status_title, convertStatus(item.getStatus()));
        if (TextUtils.equals("1", item.getStatus())) {
            helper.setGone(R.id.tv_one_btn, true);
        } else {
            helper.setGone(R.id.tv_one_btn, false);
        }
        helper.setText(R.id.tv_order_sn, item.getOrder_sn());
        helper.setText(R.id.tv_create_date, item.getCreated_at());
        helper.setText(R.id.tv_refund_money, "¥ " + item.getMoney());
        helper.setText(R.id.tv_total_price, "¥ " + item.getPay_money());

        RecyclerView rv_goods = helper.getView(R.id.rv_goods);
        RecyclerViewUtil.setVerticalManager(mContext, rv_goods);
        List<RefundListBean.DataBean.GoodsBean> list = item.getGoods();
        helper.setText(R.id.tv_count, "共" + list.size() + "种商品");
        helper.setText(R.id.tv_count2, "共" + list.size() + "种商品");

        RefundListChildAdapter childAdapter = new RefundListChildAdapter(null, item.getStore().getStore_type());
        rv_goods.setAdapter(childAdapter);
        LinearLayout mLlExpandMore = helper.getView(R.id.ll_expend_more);
        LinearLayout mLlCloseExpand = helper.getView(R.id.ll_expend_close);

        if (list.size() > mShowCount) {

            mLlExpandMore.setVisibility(View.VISIBLE);
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

            mLlExpandMore.setVisibility(View.GONE);

        }
        childAdapter.setNewData(list);
    }

    private String convertStatus(String status) {
        String result = "";
        switch (status) {
            case "1":
                result = "进行中";
                break;
            case "2":
                result = "同意退款";
                break;
            case "3":
                result = "退款成功";
                break;
            case "-1":
                result = "拒绝退款";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }
}
