package com.example.checkout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible


class ProgressBarBehavior(
    context: Context,
    attrs: AttributeSet?
) : CoordinatorLayout.Behavior<View>(context, attrs) {

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency.id == R.id.bottom_sheet
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        if (child.isVisible) {
            val height = parent.height.toFloat() - 200
            val maxSheetHeight = 1000f
            val sheetHeight = height - dependency.y // 1300 -> 0
            child.alpha = sheetHeight/maxSheetHeight
            child.y = (height + dependency.y) / 2
        }
        return false
    }
}