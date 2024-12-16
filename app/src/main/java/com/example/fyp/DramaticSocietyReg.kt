package com.example.fyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fyp.databinding.ActivityDramaticSocietyRegBinding

class DramaticSocietyReg : AppCompatActivity() {

    private lateinit var binding: ActivityDramaticSocietyRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityDramaticSocietyRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed() // Takes the user back to the previous activity
        }
    }
}
