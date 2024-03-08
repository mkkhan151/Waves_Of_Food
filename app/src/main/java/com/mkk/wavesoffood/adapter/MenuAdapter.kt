package com.mkk.wavesoffood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkk.wavesoffood.DetailsActivity
import com.mkk.wavesoffood.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItemNames: MutableList<String>,
    private val menuItemPrices: MutableList<String>,
    private val menuItemImages: MutableList<Int>,
    private val requireContext: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private val itemClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        return MenuViewHolder(MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return menuItemNames.size
    }

    inner class MenuViewHolder(
        private val binding: MenuItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                // set on click listener to open details
                val intent = Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("menuItemName", menuItemNames[position])
                intent.putExtra("menuItemImage", menuItemImages[position])
                requireContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text = menuItemNames[position]
                menuFoodPrice.text = menuItemPrices[position]
                menuImage.setImageResource(menuItemImages[position])
            }
        }
    }

    interface OnClickListener{
        fun onItemClick(position: Int)
    }
}
