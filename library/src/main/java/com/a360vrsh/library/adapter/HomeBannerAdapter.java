package com.a360vrsh.library.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.a360vrsh.baselibrary.R;
import com.a360vrsh.library.util.ImageLoaderUtil;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.List;

/**
 * 首页banner
 */
public class HomeBannerAdapter extends LoopPagerAdapter {

    List<String> imagelist;
    Context context;

    public HomeBannerAdapter(RollPagerView viewPager, Context context, List<String> imagelist) {
        super(viewPager);

        this.context = context;
        this.imagelist = imagelist;

    }


    @Override
    public View getView(ViewGroup container, final int position) {

        View convertView = LayoutInflater.from(context).inflate(R.layout.layout_banner, null);

        ImageView imageView = convertView.findViewById(R.id.iv_image);
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604464084682&di=ef226347ccb54bed1f792abc4589e6cb&imgtype=0&src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2F201801%2F19%2F143729sxvs4klys69z9fsl.jpg";
        ImageLoaderUtil.displayImage(context, url, imageView);

//        imageView.setOnClickListener(v -> {//banner图点击事件
//
//            ArrayList<String> images = new ArrayList<>();
//
//            for (HomeBannerBean.DataBean image : imagelist) {
//
//                images.add(image.getPath());
//            }
//            UiUtil.showBigImage(context, position, images);
//        });

        return convertView;
    }


    @Override
    public int getRealCount() {
        return imagelist.size();
    }
}
