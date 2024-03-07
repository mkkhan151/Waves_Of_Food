package com.mkk.wavesoffood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkk.wavesoffood.R
import com.mkk.wavesoffood.adapter.MenuAdapter
import com.mkk.wavesoffood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodNames = listOf("Herbal Pancake", "Fruit Salad", "Green Noodles", "Herbal Pancake")
    private val originalMenuFoodPrices = listOf("$5", "$7", "$8", "$10")
    private val originalMenuFoodImages = listOf(R.drawable.herbal_pancake, R.drawable.fruit_salad, R.drawable.green_noodle, R.drawable.herbal_pancake)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private  val filteredMenuFoodNames = mutableListOf<String>()
    private  val filteredMenuFoodPrices = mutableListOf<String>()
    private  val filteredMenuFoodImages = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        adapter = MenuAdapter(filteredMenuFoodNames, filteredMenuFoodPrices, filteredMenuFoodImages)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        // setup search view
        setupSearchView()

        // show all menu items
        showAllMenuItems()

        return binding.root
    }

    private fun showAllMenuItems() {
        filteredMenuFoodNames.clear()
        filteredMenuFoodPrices.clear()
        filteredMenuFoodImages.clear()

        filteredMenuFoodNames.addAll(originalMenuFoodNames)
        filteredMenuFoodPrices.addAll(originalMenuFoodPrices)
        filteredMenuFoodImages.addAll(originalMenuFoodImages)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodNames.clear()
        filteredMenuFoodPrices.clear()
        filteredMenuFoodImages.clear()

        originalMenuFoodNames.forEachIndexed { index, foodName ->
            if(foodName.contains(query.toString(), ignoreCase = true)){
                filteredMenuFoodNames.add(foodName)
                filteredMenuFoodPrices.add(originalMenuFoodPrices[index])
                filteredMenuFoodImages.add(originalMenuFoodImages[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}