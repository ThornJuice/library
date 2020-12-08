package com.a360vrsh.pansmartcitystory.adapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.a360vrsh.library.util.RecyclerViewUtil;
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
public class TicketListAdapter extends BaseQuickAdapter<TicketListBean.DataBean, BaseViewHolder> {

    OnAdapterClickListener adapterClickListener;

    public void setAdapterClickListener(OnAdapterClickListener adapterClickListener) {
        this.adapterClickListener = adapterClickListener;
    }

    public TicketListAdapter(@Nullable List<TicketListBean.DataBean> data) {
        super(R.layout.item_goos_detail_ticket, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TicketListBean.DataBean item) {
        helper.setText(R.id.tv_type, item.getType_name());
        RecyclerView rvChild = helper.getView(R.id.rv_child);
        RecyclerViewUtil.setVerticalManager(mContext, rvChild);
        TicketListChildAdapter adapter = new TicketListChildAdapter(item.getList());
        rvChild.setAdapter(adapter);
        adapter.setOnItemChildClickListener((adapter1, view, position) -> {
            if (view.getId() == R.id.tv_notice) {
                if (adapterClickListener != null) {
                    adapterClickListener.onAdapterClick(item.getType_name(), adapter.getItem(position).getId());
                }
            }
        });
    }

    public interface OnAdapterClickListener {
        void onAdapterClick(String type, String id);
    }
}
