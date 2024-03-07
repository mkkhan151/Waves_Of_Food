package com.mkk.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkk.wavesoffood.databinding.NotifictionItemBinding

class NotificationAdapter(
    private var notifications: ArrayList<String>,
    private var notificationImages: ArrayList<Int>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(NotifictionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = notifications.size
    inner class NotificationViewHolder(
        private val binding: NotifictionItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            binding.apply {
                notificationText.text = notifications[position]
                notificationImage.setImageResource(notificationImages[position])
            }
        }

    }
}