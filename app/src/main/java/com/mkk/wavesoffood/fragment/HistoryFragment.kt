package com.mkk.wavesoffood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkk.wavesoffood.R
import com.mkk.wavesoffood.adapter.BuyAgainAdapter
import com.mkk.wavesoffood.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private  lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(inflater, container, false)

        // setup recycler view
        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView(){
        val buyAgainFoodNames = arrayListOf("Spacy Fresh Crab", "Spacy Fresh Crab", "Spacy Fresh Crab", "Spacy Fresh Crab",)
        val buyAgainFoodPrices = arrayListOf("$ 35", "$ 35", "$ 35","$ 35",)
        val buyAgainFoodImages = arrayListOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu1,)

        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodNames, buyAgainFoodPrices, buyAgainFoodImages)
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.buyAgainRecyclerView.adapter = buyAgainAdapter
    }

    companion object {

    }
}