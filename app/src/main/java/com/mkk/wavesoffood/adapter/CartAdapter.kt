package com.mkk.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkk.wavesoffood.databinding.CartItemBinding

class CartAdapter(
    private val cartItems: MutableList<String>,
    private val cartItemPrices: MutableList<String>,
    private val cartItemImages: MutableList<Int>
): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemsQuantities = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return this.cartItems.size
    }

    inner class CartViewHolder(
        private val binding: CartItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                cartFoodName.text = cartItems[position]
                cartItemPrice.text = cartItemPrices[position]
                cartImage.setImageResource(cartItemImages[position])
                cartItemQuantity.text = itemsQuantities[position].toString()
            }

        }

    }
}