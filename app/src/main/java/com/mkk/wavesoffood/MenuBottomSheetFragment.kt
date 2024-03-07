package com.mkk.wavesoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mkk.wavesoffood.adapter.MenuAdapter
import com.mkk.wavesoffood.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.backButton.setOnClickListener {
            dismiss()
        }

        val menuFoodNames = listOf("Herbal Pancake", "Fruit Salad", "Green Noodles", "Herbal Pancake", "Herbal Pancake", "Fruit Salad", "Green Noodles", "Herbal Pancake")
        val menuFoodPrices = listOf("$5", "$7", "$8", "$10", "$5", "$7", "$8", "$10")
        val menuFoodImages = listOf(R.drawable.herbal_pancake, R.drawable.fruit_salad, R.drawable.green_noodle, R.drawable.herbal_pancake, R.drawable.herbal_pancake, R.drawable.fruit_salad, R.drawable.green_noodle, R.drawable.herbal_pancake)
        val adapter = MenuAdapter(ArrayList(menuFoodNames), ArrayList(menuFoodPrices), ArrayList(menuFoodImages))

        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

    }
}