package com.a360vrsh.pansmartcitystory.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.a360vrsh.library.util.ImageLoaderUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.GoodsListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 商品列表adater
 */
public class GoodsListAdapter extends BaseQuickAdapter<GoodsListBean.DataBean, BaseViewHolder> {

    public GoodsListAdapter(@Nullable List<GoodsListBean.DataBean> data) {
        super(R.layout.item_my_goods, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsListBean.DataBean item) {
        LinearLayout ll_operation = helper.getView(R.id.ll_operation);
        TextView tv_one_btn = helper.getView(R.id.tv_one_btn);
        TextView tv_editing= helper.getView(R.id.tv_editing);
        if (TextUtils.equals(item.getIs_lvmama(), "1")) {//驴妈妈商品隐藏操作按钮
            ll_operation.setVisibility(View.GONE);
        } else {
            ll_operation.setVisibility(View.VISIBLE);
        }
        String audit = item.getStatus_audit();//0 编辑中 1审核中 2审核通过 3审核拒绝 4 审核中

        if (TextUtils.equals("0", audit)) {//编辑中显示文字
            tv_editing.setVisibility(View.VISIBLE);
        } else {
            tv_editing.setVisibility(View.GONE);
        }
        if (TextUtils.equals("2", audit)) {
            tv_one_btn.setVisibility(View.VISIBLE);
            if (TextUtils.equals("1", item.getStatus_shelf())) {
                helper.setText(R.id.tv_one_btn, "下架");
            } else if (TextUtils.equals("2", item.getStatus_shelf())) {
                helper.setText(R.id.tv_one_btn, "上架");
            }
        } else {
            tv_one_btn.setVisibility(View.GONE);
        }

        helper.addOnClickListener(R.id.tv_one_btn, R.id.tv_two_btn);
        helper.setText(R.id.tv_goods_title, item.getTitle());
        helper.setText(R.id.tv_goods_sales, "销量" + item.getSales_total());
//        helper.setText(R.id.tv_goods_collect, "收藏量");
        if (TextUtils.equals(item.getPrice(), item.getPrice_max())) {
            helper.setText(R.id.tv_goods_price, "¥ " + item.getPrice());
        } else {
            if (TextUtils.isEmpty(item.getPrice_max())) {
                helper.setText(R.id.tv_goods_price, "¥ " + item.getPrice());
            } else {
                helper.setText(R.id.tv_goods_price, "¥ " + item.getPrice() + "至¥ " + item.getPrice_max());
            }
        }

        ImageView imageView = helper.getView(R.id.iv_image);
        ImageLoaderUtil.displayImage(mContext, item.getCover_image(), imageView);


    }

}
