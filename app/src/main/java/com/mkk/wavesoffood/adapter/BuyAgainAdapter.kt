package com.mkk.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkk.wavesoffood.databinding.BuyAgainItemBinding

class BuyAgainAdapter(
    private val buyAgainFoodNames: ArrayList<String>,
    private val buyAgainFoodPrices: ArrayList<String>,
    private val buyAgainFoodImages: ArrayList<Int>,
) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BuyAgainAdapter.BuyAgainViewHolder {
        return BuyAgainViewHolder(BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BuyAgainAdapter.BuyAgainViewHolder, position: Int) {
        holder.bind(buyAgainFoodNames[position], buyAgainFoodPrices[position], buyAgainFoodImages[position])
    }

    override fun getItemCount(): Int = buyAgainFoodNames.size

    class BuyAgainViewHolder(
        private val binding: BuyAgainItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, price: String, image: Int) {
            binding.apply {
                buyAgainFoodName.text = name
                buyAgainFoodPrice.text = price
                buyAgainFoodImage.setImageResource(image)
            }
        }
    }
}