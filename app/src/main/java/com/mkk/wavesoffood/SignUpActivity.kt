package com.mkk.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mkk.wavesoffood.databinding.ActivitySignUpBinding
import com.mkk.wavesoffood.databinding.ActivityStartBinding

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.haveButton.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
            super.onBackPressed()
        }

        binding.createAcountButton.setOnClickListener {
            val intent = Intent(this, ChooseLocationActivity::class.java)
            startActivity(intent)
        }
    }
}