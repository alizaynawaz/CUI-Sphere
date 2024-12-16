package com.example.fyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fyp.databinding.ActivityFaqscreenBinding

class FAQScreen : AppCompatActivity() {

    private lateinit var binding: ActivityFaqscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFaqscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}
