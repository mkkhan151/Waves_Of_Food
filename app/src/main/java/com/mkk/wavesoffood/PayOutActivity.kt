package com.mkk.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mkk.wavesoffood.databinding.ActivityPayOutBinding
import com.mkk.wavesoffood.databinding.FragmentCongratsBottomSheetBinding

class PayOutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeOrderButton.setOnClickListener {
            val congratsBottomSheetDialog = CongratsBottomSheetFragment()
            congratsBottomSheetDialog.show(supportFragmentManager, "Test")
        }
    }
}