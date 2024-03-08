package com.mkk.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mkk.wavesoffood.databinding.ActivityDetailsBinding
import com.mkk.wavesoffood.databinding.ActivityPayOutBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("menuItemName")
        val foodImage = intent.getIntExtra("menuItemImage", 0)
        binding.detailFoodName.text = foodName
        binding.detailFoodImage.setImageResource(foodImage)

        binding.imageButton.setOnClickListener {
            finish()
        }

    }
}