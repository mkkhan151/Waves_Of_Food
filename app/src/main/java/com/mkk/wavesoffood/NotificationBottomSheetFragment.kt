package com.mkk.wavesoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mkk.wavesoffood.adapter.NotificationAdapter
import com.mkk.wavesoffood.databinding.FragmentNotificationBottomSheetBinding

class NotificationBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomSheetBinding.inflate(inflater, container, false)

        val notifications = arrayListOf("Your order has been Canceled Successfully", "Order has been taken by the driver", "Congrats Your Order Placed")
        val notificationImages = arrayListOf(R.drawable.sademoji, R.drawable.ontheway, R.drawable.placed)
        val adapter = NotificationAdapter(notifications, notificationImages)

        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

    }
}