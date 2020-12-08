package com.a360vrsh.pansmartcitystory.activity.goods

import android.graphics.Canvas
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.a360vrsh.library.base.BaseTitleActivity
import com.a360vrsh.library.util.LogUtil
import com.a360vrsh.library.util.MMKVUtil
import com.a360vrsh.library.util.RecyclerViewUtil
import com.a360vrsh.library.util.setSingleClick
import com.a360vrsh.library.widget.CommonPopupWindow
import com.a360vrsh.library.widget.CommonPopupWindow.onViewCallBack
import com.a360vrsh.pansmartcitystory.R
import com.a360vrsh.pansmartcitystory.adapter.AddGoodsClassListAdapter
import com.a360vrsh.pansmartcitystory.bean.GoodsClassBean
import com.a360vrsh.pansmartcitystory.util.UiUtil
import com.a360vrsh.pansmartcitystory.util.getContext
import com.a360vrsh.pansmartcitystory.util.setTxtColor
import com.a360vrsh.pansmartcitystory.util.showToast
import com.a360vrsh.pansmartcitystory.viewmodel.goods.AddGoodsClassViewModel
import kotlinx.android.synthetic.main.activity_add_goods_class.*
import java.util.*


/**
 * 添加商品分类
 * */
class AddGoodsClassActivity : BaseTitleActivity() {
    private lateinit var viewModel: AddGoodsClassViewModel

    private val mAdapter: AddGoodsClassListAdapter by lazy { AddGoodsClassListAdapter(null) }
    private var editPopupWindow: CommonPopupWindow? = null

    private var mItemTouchHelper: ItemTouchHelper? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_add_goods_class
    }

    override fun initView() {
        viewModel = initViewModel(AddGoodsClassViewModel::class.java) as AddGoodsClassViewModel

        titleText.text = "添加商品"
        tvRight.text = "添加分类"
        tvRight.setTxtColor(this@AddGoodsClassActivity, R.color.mainColor)

        RecyclerViewUtil.setVerticalManager(getContext(), recyclerView)
        recyclerView.adapter = mAdapter

        mItemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {
                val itemViewType = viewHolder.itemViewType
                viewHolder.itemView.alpha = 0.7f
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
                    LogUtil.e(TAG, "fromPosition:" + fromPosition + "toPosition:" + toPosition)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                return true
            }

            override fun clearView(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ) {
                viewHolder.itemView.alpha = 1f
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
        })
        // 绑定拖拽事件
        mItemTouchHelper?.attachToRecyclerView(recyclerView)
    }


    override fun initListener() {
        llRight.setSingleClick {
            showAddOrEditPopup(null)
        }
//        llRight.setOnClickListener {
//            showAddOrEditPopup(null)
//        }

        mAdapter.apply {
            setOnItemChildClickListener { _, view, position ->
                val item = this.getItem(position)
                if (view.id == R.id.tv_edit) {
                    showAddOrEditPopup(item)
                } else if (view.id == R.id.tv_delete) {
                    UiUtil.getDialog(this@AddGoodsClassActivity, "提示", "确定删除该分类？")
                        .setPositive("确定") { v ->
                            item?.let {
                                viewModel.deleteGoodsClass(
                                    getContext(),
                                    it.id,
                                    MMKVUtil.getStoreId(),
                                    true
                                )
                            }

                        }
                        .setNegative("取消") { v -> }
                        .show(supportFragmentManager)
                }
            }
        }
    }

    override fun initObserver() {
        viewModel.goodsClassLiveData.observe(this, Observer {

            mAdapter.setNewData(it.data)

        })
        viewModel.addSuccessLiveData.observe(this, Observer {

            showToast("操作成功")
            viewModel.getGoodsClass(getContext(), MMKVUtil.getStoreId(), true)

        })
    }

    override fun initData() {
        //获取商品分类
        viewModel.getGoodsClass(getContext(), MMKVUtil.getStoreId(), true)
    }

    /**
     * 编辑添加弹框
     * */
    private fun showAddOrEditPopup(classBean: GoodsClassBean.DataBean?) {
        editPopupWindow?.cancel()
        editPopupWindow =
            CommonPopupWindow.Builder(this@AddGoodsClassActivity)
                .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setHeight(ViewGroup.LayoutParams.MATCH_PARENT)
                .setContentView(R.layout.layout_add_goods_class_dialog)
                .setAnimationStyle(R.style.library_scale_fade_in_and_out_anim)
                .setFocusable(true)
                .setOutsideTouchable(false)
                .enableBackgroundAlpha(true)
                .setOnCreateView(onViewCallBack { view ->

                    val tvTitle = view.findViewById<TextView>(R.id.tv_title)
                    val editContent = view.findViewById<EditText>(R.id.edt_content)
                    classBean?.let {
                        tvTitle.text = "编辑分类"
                        editContent.setText(classBean.name)
                    }

                    view.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
                        editPopupWindow?.dismiss()
                    }
                    view.findViewById<TextView>(R.id.tv_confirm).setOnClickListener {
                        val classNameVal = editContent.text.toString().trim()
                        if (classNameVal.isEmpty()) {
                            showToast("请输入分类名称")
                        } else {
                            editPopupWindow?.dismiss()

                            if (classBean == null) {
                                addClass(classNameVal)
                            } else {
                                editClass(classBean.id, classNameVal)
                            }
                        }
                    }
                }).setOnDismissListener {

                }
                .create()
                .showAtLocation(findViewById<View>(R.id.ll_root), Gravity.NO_GRAVITY, 0, 0)
    }

    /**
     * 添加分类
     * */
    private fun editClass(id: String, name: String) {
        viewModel.editGoodsClass(
            this@AddGoodsClassActivity,
            id,
            MMKVUtil.getStoreId(),
            name, "0", true
        )
    }

    /**
     * 编辑分类
     * */
    private fun addClass(name: String) {
        viewModel.addGoodsClass(
            this@AddGoodsClassActivity,
            MMKVUtil.getStoreId(),
            name, "0", true
        )
    }
}