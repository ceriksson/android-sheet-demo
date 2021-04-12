package com.example.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CheckoutMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val paymentOptionsView = view.findViewById<RecyclerView>(R.id.payment_options_view)
        val adapter = GroupAdapter<GroupieViewHolder>()

        paymentOptionsView.adapter = adapter
    }
}

class PaymentOptionItem: Item<GroupieViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.payment_option_item
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

    }

}