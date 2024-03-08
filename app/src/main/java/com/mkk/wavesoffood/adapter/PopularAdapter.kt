package com.mkk.wavesoffood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkk.wavesoffood.DetailsActivity
import com.mkk.wavesoffood.MainActivity
import com.mkk.wavesoffood.databinding.PopularListItemBinding

class PopularAdapter(
    private val items:List<String>,
    private val prices:List<String>,
    private val images:List<Int>,
    private val requireContext: Context
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val image = images[position]
        val price = prices[position]
        holder.bind(item, price, image)

        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("menuItemName", item)
            intent.putExtra("menuItemImage", image)
            requireContext.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }

    class PopularViewHolder (
        private val binding: PopularListItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: String,price: String, image: Int){
            binding.foodName.text = item
            binding.foodPrice.text = price
            binding.foodImage.setImageResource(image)
        }

    }
}
