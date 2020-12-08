package com.a360vrsh.pansmartcitystory.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.a360vrsh.library.util.ImageLoaderUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.EvaluateListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 评价图片adater
 */
public class EvaluateImageAdapter extends BaseQuickAdapter<EvaluateListBean.DataBean.image, BaseViewHolder> {

    public EvaluateImageAdapter(@Nullable List<EvaluateListBean.DataBean.image> data) {
        super(R.layout.item_goods_detail_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EvaluateListBean.DataBean.image item) {

        ImageView imageView = helper.getView(R.id.iv_image);
        ImageLoaderUtil.displayImage(mContext, item.getUrl(), imageView);

    }

}
