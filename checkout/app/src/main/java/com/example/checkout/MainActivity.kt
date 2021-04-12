package com.example.checkout

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback


class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController // don't forget to initialize

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = Navigation.findNavController(this, R.id.nav_host_fragment)
        val button = findViewById<Button>(R.id.show_checkout_button)
        val bottomSheet = findViewById<ConstraintLayout>(R.id.bottom_sheet)
        val behavior = BottomSheetBehavior.from(bottomSheet)

        button.setOnClickListener {

            behavior.setPeekHeight(1200, true)

            behavior.state = BottomSheetBehavior.STATE_COLLAPSED

        }

        val nextButton = findViewById<Button>(R.id.next_button)

        nextButton.setOnClickListener {
            when (controller.currentBackStackEntry?.destination?.id) {
                R.id.CheckoutMenuFragment -> {
                    controller.navigate(R.id.action_CheckoutMenuFragment_to_CardFormFragment)
                }
                R.id.CardFormFragment -> {
                    controller.navigate(R.id.action_CardFormFragment_to_CheckoutMenuFragment)
                }
            }
        }

        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    controller.popBackStack(R.id.CheckoutMenuFragment, false)
                }
            }
        })
    }

    private val listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        val nextButton = findViewById<Button>(R.id.next_button)
        val bottomSheet = findViewById<ConstraintLayout>(R.id.bottom_sheet)
        val behavior = BottomSheetBehavior.from(bottomSheet)
        when (destination.id) {
            R.id.CheckoutMenuFragment -> {
                if (behavior.state != BottomSheetBehavior.STATE_HIDDEN) {
                    nextButton.isVisible = true
                }
                nextButton.tag = R.id.CheckoutMenuFragment
                nextButton.text = "Pay"
            }
            R.id.CardFormFragment -> {
                nextButton.isVisible = false
                nextButton.tag = R.id.CardFormFragment
//                nextButton.text = "Pay"
            }
        }
    }

    override fun onResume() {
        super.onResume()
        controller.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        controller.removeOnDestinationChangedListener(listener)
        super.onPause()
    }
}