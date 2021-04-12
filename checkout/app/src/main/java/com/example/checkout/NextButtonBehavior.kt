package com.example.checkout

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.bottomsheet.BottomSheetBehavior


class NextButtonBehavior(
    context: Context,
    attrs: AttributeSet?
) : CoordinatorLayout.Behavior<View>() {

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

        if (child.tag == R.id.CardFormFragment) {
            child.isVisible = false
        } else {
            val height = parent.height.toFloat()
            val maxSheetHeight = 1200f
            val sheetHeight = -(dependency.y - height)
            child.alpha = sheetHeight/maxSheetHeight
            child.isVisible = dependency.y < height
        }


        return false
    }
}