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
public class MyPanoImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyPanoImageAdapter(@Nullable List<String> data) {
        super(R.layout.item_goods_detail_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        ImageView imageView = helper.getView(R.id.iv_image);
        ImageLoaderUtil.displayImage(mContext, item, imageView);

    }

}
