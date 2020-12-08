package com.a360vrsh.pansmartcitystory.widget;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;

/**
 * @author: wxj
 * @date: 2020/10/26
 * @description:
 */
public class DragSwipeCallback extends ItemDragAndSwipeCallback {
    private int mFixedPosition = -1; //固定的下标（不可移动）
    public void setFixedPosition(int fixedPosition) {
        mFixedPosition = fixedPosition;
    }
    public DragSwipeCallback(BaseItemDraggableAdapter adapter) {
        super(adapter);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (viewHolder.getAdapterPosition() == mFixedPosition || target.getAdapterPosition() == mFixedPosition) {
            return false;
        }
        return viewHolder.getItemViewType() == target.getItemViewType();
    }
}
