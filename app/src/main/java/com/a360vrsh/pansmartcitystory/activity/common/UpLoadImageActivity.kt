package com.a360vrsh.pansmartcitystory.activity.common

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Canvas
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.a360vrsh.library.adapter.GridImageAdapter
import com.a360vrsh.library.listener.PicSelectResultCallback
import com.a360vrsh.library.util.GlideEngine
import com.a360vrsh.library.util.ToastUtil
import com.a360vrsh.library.widget.FullyGridLayoutManager
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.util.getContext
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.luck.picture.lib.permissions.PermissionChecker
import com.luck.picture.lib.tools.PictureFileUtils
import com.luck.picture.lib.tools.ScreenUtils
import kotlinx.android.synthetic.main.activity_up_load_image.*
import java.util.*


class UpLoadImageActivity : AppCompatActivity() {
    private val TAG = "UpLoadImageActivity"
    private lateinit var mAdapter: GridImageAdapter
    private var mItemTouchHelper: ItemTouchHelper? = null
    private var onAddPicClickListener: GridImageAdapter.onAddPicClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_up_load_image)

        val manager = FullyGridLayoutManager(
            this,
            3, GridLayoutManager.VERTICAL, false
        )
        mRecyclerView.layoutManager = manager

        mRecyclerView.addItemDecoration(
            GridSpacingItemDecoration(
                3,
                ScreenUtils.dip2px(this, 8f), false
            )
        )
        onAddPicClickListener = GridImageAdapter.onAddPicClickListener {
            PictureSelector.create(this@UpLoadImageActivity)
                .openGallery(PictureMimeType.ofImage())
                .imageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
                .minSelectNum(1)
                .maxSelectNum(6)
                .imageSpanCount(4)
                .selectionData(mAdapter.data)// 是否传入已选图片
                .forResult(PicSelectResultCallback(mAdapter));
        }
        mItemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val itemViewType = viewHolder.itemViewType
                if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
                    viewHolder.itemView.alpha = 0.7f
                }
                return makeMovementFlags(
                    ItemTouchHelper.DOWN or ItemTouchHelper.UP
                            or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT, 0
                )
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                try {
                    //得到item原来的position
                    val fromPosition = viewHolder.adapterPosition
                    //得到目标position
                    val toPosition = target.adapterPosition
                    val itemViewType = target.itemViewType
                    if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
                        if (fromPosition < toPosition) {
                            for (i in fromPosition until toPosition) {
                                Collections.swap(mAdapter.data, i, i + 1)
                            }
                        } else {
                            for (i in fromPosition downTo toPosition + 1) {
                                Collections.swap(mAdapter.data, i, i - 1)
                            }
                        }
                        mAdapter.notifyItemMoved(fromPosition, toPosition)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return true
            }

            override fun clearView(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ) {
                val itemViewType = viewHolder.itemViewType
                if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
                    viewHolder.itemView.alpha = 1f
                }
                super.clearView(recyclerView, viewHolder)
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val itemViewType = viewHolder.itemViewType
                if (itemViewType != GridImageAdapter.TYPE_CAMERA) {
                    super.onChildDraw(
                        c,
                        recyclerView,
                        viewHolder,
                        dX,
                        dY,
                        actionState,
                        isCurrentlyActive
                    )
                }

            }
        })
        mAdapter = GridImageAdapter(getContext(), onAddPicClickListener)

        mAdapter.setSelectMax(6)
        mRecyclerView.adapter = mAdapter

        // 绑定拖拽事件
        mItemTouchHelper?.attachToRecyclerView(mRecyclerView)

        initView()

    }

    private fun initView() {

        tv_comfirm.setOnClickListener {
            if (mAdapter.data.isNotEmpty()){
                ToastUtil.show("size:"+mAdapter.data.size+"..."+mAdapter.data[0].realPath)
            }

        }
    }


    /**
     * 清空缓存包括裁剪、压缩、AndroidQToPath所生成的文件，注意调用时机必须是处理完本身的业务逻辑后调用；非强制性
     */
    private fun clearCache() {
        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        if (PermissionChecker.checkSelfPermission(
                this@UpLoadImageActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            //PictureFileUtils.deleteCacheDirFile(this, PictureMimeType.ofImage());
            PictureFileUtils.deleteAllCacheDirFile(this@UpLoadImageActivity)
        } else {
            PermissionChecker.requestPermissions(
                this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PictureConfig.APPLY_STORAGE_PERMISSIONS_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PictureConfig.APPLY_STORAGE_PERMISSIONS_CODE ->                 // 存储权限
            {
                var i = 0
                while (i < grantResults.size) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        PictureFileUtils.deleteCacheDirFile(getContext(), PictureMimeType.ofImage())
                    } else {
                        ToastUtil.show(getString(R.string.picture_jurisdiction))
                    }
                    i++
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        clearCache()
    }
}