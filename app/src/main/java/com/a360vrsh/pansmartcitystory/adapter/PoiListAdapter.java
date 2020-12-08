package com.a360vrsh.pansmartcitystory.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.a360vrsh.pansmartcitystory.R;
import com.baidu.mapapi.search.core.PoiInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description:
 */
public class PoiListAdapter extends BaseQuickAdapter<PoiInfo, BaseViewHolder> {
    int position = -1;//选中的位置

    public PoiListAdapter(@Nullable List<PoiInfo> data) {
        super(R.layout.item_baidu_poi, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PoiInfo item) {

        helper.setText(R.id.tv_name, item.name);
        helper.setText(R.id.tv_detail, item.address);
        ImageView iv_check = helper.getView(R.id.iv_check);
        if (position == helper.getLayoutPosition()) {
            iv_check.setVisibility(View.VISIBLE);
        } else {
            iv_check.setVisibility(View.GONE);
        }
    }

    public void setPosition(int position) {
        this.position = position;
        notifyDataSetChanged();
    }

    public int getPosition() {
        return position;
    }

    public PoiInfo getSelectItem() {
        return getItem(position);
    }
}
