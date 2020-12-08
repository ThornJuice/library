package com.a360vrsh.pansmartcitystory.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.a360vrsh.library.util.ImageLoaderUtil;
import com.a360vrsh.library.util.LogUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.FunctionBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 首页-常用功能adater
 */
public class HomeFunctionAdapter extends BaseQuickAdapter<FunctionBean, BaseViewHolder> {

    public HomeFunctionAdapter(@Nullable List<FunctionBean> data) {
        super(R.layout.item_home_function, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FunctionBean item) {
        helper.setText(R.id.tv_name, item.getName());
        ImageView imageView = helper.getView(R.id.iv_image);
        imageView.setImageResource(item.getIcon());
//        ImageLoaderUtil.displayImage(mContext, item.getIcon(), imageView);
    }

}
