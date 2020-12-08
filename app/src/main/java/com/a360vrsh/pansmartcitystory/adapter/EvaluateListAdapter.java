package com.a360vrsh.pansmartcitystory.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.a360vrsh.library.util.ImageLoaderUtil;
import com.a360vrsh.library.util.MMKVUtil;
import com.a360vrsh.library.util.RecyclerViewUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.EvaluateListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

/**
 * @author: wxj
 * @date: 2020/11/2
 * @description:
 */
public class EvaluateListAdapter extends BaseQuickAdapter<EvaluateListBean.DataBean, BaseViewHolder> {

    public EvaluateListAdapter(@Nullable List<EvaluateListBean.DataBean> data) {
        super(R.layout.item_evaluate, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EvaluateListBean.DataBean item) {
        ImageView imageView = helper.getView(R.id.iv_image);
        ImageLoaderUtil.displayImage(mContext, item.getUser_avatar(), imageView);
        helper.setText(R.id.tv_nick_name, item.getUser_nickname());

        if (TextUtils.isEmpty(item.getContent())) {
            helper.setText(R.id.tv_content, "该用户暂未填写评价");
        } else {
            helper.setText(R.id.tv_content, item.getContent());
        }
        helper.setText(R.id.tv_create_date, item.getCreated_at());
        SimpleRatingBar ratingBar = helper.getView(R.id.rating_bar);
        try {
            ratingBar.setRating(Float.parseFloat(item.getScore()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        RecyclerView rv_images = helper.getView(R.id.rv_images);
        EvaluateImageAdapter imageAdapter = new EvaluateImageAdapter(item.getImage());
        RecyclerViewUtil.setGridManager(mContext, rv_images, 3);
        rv_images.setAdapter(imageAdapter);
        TagFlowLayout tagFlowLayout = helper.getView(R.id.tagFlowLayout);
        if (TextUtils.equals(MMKVUtil.getStoreType(), "1")) {
            tagFlowLayout.setAdapter(new TagAdapter<String>(item.getGoods()) {
                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_goods_tag,
                            tagFlowLayout, false);
                    tv.setText(s);
                    return tv;
                }

            });
        } else {
            tagFlowLayout.setVisibility(View.GONE);
        }

    }
}
