package com.a360vrsh.pansmartcitystory.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.a360vrsh.library.util.ImageLoaderUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.ArticleListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description:
 */
public class ArticleListAdapter extends BaseQuickAdapter<ArticleListBean.DataBean, BaseViewHolder> {


    public ArticleListAdapter(@Nullable List<ArticleListBean.DataBean> data) {
        super(R.layout.item_article_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleListBean.DataBean item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setText(R.id.tv_date,item.getCreated_at());
        ImageView imageView = helper.getView(R.id.iv_image);
        ImageLoaderUtil.displayImage(mContext, item.getCover_image(), imageView);
    }
}
