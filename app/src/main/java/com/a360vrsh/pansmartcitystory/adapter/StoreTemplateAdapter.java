package com.a360vrsh.pansmartcitystory.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.a360vrsh.library.util.ImageLoaderUtil;
import com.a360vrsh.pansmartcitystory.R;
import com.a360vrsh.pansmartcitystory.bean.TemplateBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 店铺模板adater
 */
public class StoreTemplateAdapter extends BaseQuickAdapter<TemplateBean, BaseViewHolder> {
    String selectTemplate = "0";

    public StoreTemplateAdapter(@Nullable List<TemplateBean> data) {
        super(R.layout.item_store_template, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TemplateBean item) {
        helper.addOnClickListener(R.id.ll_check);
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_explain, item.getExplain());
        ImageView imageView = helper.getView(R.id.iv_image);
        ImageLoaderUtil.displayImage(mContext, item.getImage(), imageView);
        ImageView iv_check = helper.getView(R.id.iv_check);
        if (TextUtils.equals(selectTemplate, item.getTemplate())) {
            iv_check.setImageResource(R.mipmap.icon_square_checked);
        } else {
            iv_check.setImageResource(R.mipmap.icon_square_unchecked);
        }
        imageView.setOnClickListener(v -> {

        });
    }

    public void setSelectTemplate(String template) {
        this.selectTemplate = template;
        notifyDataSetChanged();
    }

    public String getTemplateName(String template) {
        for (int i = 0; i < getData().size(); i++) {
            if (TextUtils.equals(template, getData().get(i).getTemplate())) {
                return getData().get(i).getName();
            }
        }
        return "";
    }
}
