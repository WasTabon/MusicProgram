package com.example.musicprogram

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            // Установите margin только между элементами, а не перед первым и после последнего
            if (parent.getChildAdapterPosition(view) != 0) {
                top = margin
            }
        }
    }
}