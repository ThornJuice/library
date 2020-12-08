package com.a360vrsh.pansmartcitystory.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.a360vrsh.baselibrary.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnItemClickListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 多图上传布局
 */
public class EditGoodsUpLoadImageAdapter extends
        RecyclerView.Adapter<EditGoodsUpLoadImageAdapter.ViewHolder> {
    public static final String TAG = "PictureSelector";
    public static final int TYPE_CAMERA = 1;
    public static final int TYPE_PICTURE = 2;
    private LayoutInflater mInflater;
    private List<LocalMedia> list = new ArrayList<>();
    private List<String> upLoadImagePathList = new ArrayList<>();//上传的图片path
    private int selectMax = 5;
    /**
     * 点击添加图片跳转
     */
    private onAddPicClickListener mOnAddPicClickListener;

    public interface onAddPicClickListener {
        void onAddPicClick();
    }

    /**
     * 删除
     */
    public void delete(int position) {
        try {

            if (position != RecyclerView.NO_POSITION && list.size() > position) {
                list.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, list.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EditGoodsUpLoadImageAdapter(Context context, onAddPicClickListener mOnAddPicClickListener) {
        this.mInflater = LayoutInflater.from(context);
        this.mOnAddPicClickListener = mOnAddPicClickListener;
    }

    public void setSelectMax(int selectMax) {
        this.selectMax = selectMax;
    }

    public void setList(List<LocalMedia> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addData(LocalMedia localMedia) {
        this.list.add(localMedia);
        notifyDataSetChanged();
    }

    public void addData(List<LocalMedia> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void addUpLoadImagePath(String path) {
        upLoadImagePathList.add(path);
    }

    public void removeUpLoadImagePath(String path) {
        upLoadImagePathList.remove(path);
    }

    public List<String> getUpLoadImagePaths() {
        return upLoadImagePathList;
    }

    public List<LocalMedia> getData() {
        return list == null ? new ArrayList<>() : list;
    }

    public void remove(int position) {
        if (list != null && position < list.size()) {
            list.remove(position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImg;
        ImageView mIvDel;

        public ViewHolder(View view) {
            super(view);
            mImg = view.findViewById(R.id.iv_image);
            mIvDel = view.findViewById(R.id.iv_delete);
        }
    }

    @Override
    public int getItemCount() {
        if (list.size() < selectMax) {
            return list.size() + 1;
        } else {
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isShowAddItem(position)) {
            return TYPE_CAMERA;
        } else {
            return TYPE_PICTURE;
        }
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.library_item_select_pics,
                viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    private boolean isShowAddItem(int position) {
        int size = list.size();
        return position == size;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        //少于6张，显示继续添加的图标
        if (getItemViewType(position) == TYPE_CAMERA) {
            viewHolder.mImg.setImageResource(R.mipmap.ic_add_pic2);
            viewHolder.mImg.setOnClickListener(v -> mOnAddPicClickListener.onAddPicClick());
            viewHolder.mIvDel.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.mIvDel.setVisibility(View.VISIBLE);
            viewHolder.mIvDel.setOnClickListener(view -> {
                int index = viewHolder.getAdapterPosition();

                if (index != RecyclerView.NO_POSITION && list.size() > index) {
                    list.remove(index);
                    if (upLoadImagePathList.size() > index) {
                        upLoadImagePathList.remove(index);
                    }
                    notifyItemRemoved(index);
                    notifyItemRangeChanged(index, list.size());
                }
            });
            LocalMedia media = list.get(position);
            if (media == null
                    || TextUtils.isEmpty(media.getPath())) {
                return;
            }
            int chooseModel = media.getChooseModel();
            String path;
            if (media.isCut() && !media.isCompressed()) {
                // 裁剪过
                path = media.getCutPath();
            } else if (media.isCompressed() || (media.isCut() && media.isCompressed())) {
                // 压缩过,或者裁剪同时压缩过,以最终压缩过图片为准
                path = media.getCompressPath();
            } else {
                // 原图
                path = media.getPath();
            }

            Log.i(TAG, "原图地址uri::" + media.getPath());
            Log.i(TAG, "原图地址path::" + media.getRealPath());
            if (media.isCut()) {
                Log.i(TAG, "裁剪地址::" + media.getCutPath());
            }
            if (media.isCompressed()) {
                Log.i(TAG, "压缩地址::" + media.getCompressPath());
                Log.i(TAG, "压缩后文件大小::" + new File(media.getCompressPath()).length() / 1024 + "k");
            }
            if (!TextUtils.isEmpty(media.getAndroidQToPath())) {
                Log.i(TAG, "Android Q特有地址::" + media.getAndroidQToPath());
            }
            if (media.isOriginal()) {
                Log.i(TAG, "是否开启原图功能::" + true);
                Log.i(TAG, "开启原图功能后地址::" + media.getOriginalPath());
            }


            Glide.with(viewHolder.itemView.getContext())
                    .load(PictureMimeType.isContent(path) && !media.isCut() && !media.isCompressed() ? Uri.parse(path)
                            : path)
                    .centerCrop()
                    .placeholder(R.color.library_f6)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.mImg);

            //itemView 的点击事件
            if (mItemClickListener != null) {
                viewHolder.itemView.setOnClickListener(v -> {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    mItemClickListener.onItemClick(v, adapterPosition);
                });
            }

            if (mItemLongClickListener != null) {
                viewHolder.itemView.setOnLongClickListener(v -> {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    mItemLongClickListener.onItemLongClick(viewHolder, adapterPosition, v);
                    return true;
                });
            }
        }
    }

    private OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(OnItemClickListener l) {
        this.mItemClickListener = l;
    }

    private OnItemLongClickListener mItemLongClickListener;

    public void setItemLongClickListener(OnItemLongClickListener l) {
        this.mItemLongClickListener = l;
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(RecyclerView.ViewHolder holder, int position, View v);
    }
}
