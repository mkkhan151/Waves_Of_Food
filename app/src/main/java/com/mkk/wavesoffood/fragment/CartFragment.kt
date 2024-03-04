package com.mkk.wavesoffood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkk.wavesoffood.R
import com.mkk.wavesoffood.adapter.CartAdapter
import com.mkk.wavesoffood.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        val cartItems = mutableListOf("Spacy fresh crab", "Spacy fresh crab", "Spacy fresh crab", "Spacy fresh crab", "Spacy fresh crab", "Spacy fresh crab")
        val itemPrices = mutableListOf("$ 35", "$ 35", "$ 35", "$ 35", "$ 35", "$ 35")
        val images = mutableListOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu1, R.drawable.menu2, R.drawable.menu3)


        val adapter = CartAdapter(cartItems, itemPrices, images)
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

    }
}