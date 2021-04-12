package com.example.checkout

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class CardFormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("CardFormFragment", "🏓")
        return inflater.inflate(R.layout.fragment_card_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("CardFormFragment", "🌠 ⛩")
//        view.findViewById<Button>(R.id.show_checkout_button).setOnClickListener {
//            findNavController().navigate(R.id.action_CardFormFragment_to_CheckoutMenuFragment)
//        }
    }

    override fun onResume() {
        // set button to
        super.onResume()
    }
}