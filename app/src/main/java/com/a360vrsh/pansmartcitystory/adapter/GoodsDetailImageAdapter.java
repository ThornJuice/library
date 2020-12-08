package com.a360vrsh.pansmartcitystory.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.a360vrsh.library.util.ImageLoaderUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.GoodsDetailBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 商品详情页-商品图片adater
 */
public class GoodsDetailImageAdapter extends BaseQuickAdapter<GoodsDetailBean.DataBean.ImagesBean, BaseViewHolder> {

    public GoodsDetailImageAdapter(@Nullable List<GoodsDetailBean.DataBean.ImagesBean> data) {
        super(R.layout.item_goods_detail_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsDetailBean.DataBean.ImagesBean item) {

        ImageView imageView = helper.getView(R.id.iv_image);
        ImageLoaderUtil.displayImage(mContext, item.getUrl(), imageView);

    }

}
