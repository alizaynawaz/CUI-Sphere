package com.example.fyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fyp.databinding.ActivityMediaSocietyRegBinding

class MediaSocietyReg : AppCompatActivity() {

    private lateinit var binding: ActivityMediaSocietyRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityMediaSocietyRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed() // Takes the user back to the previous activity
        }
    }
}
