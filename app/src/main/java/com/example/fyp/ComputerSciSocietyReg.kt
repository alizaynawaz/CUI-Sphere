package com.example.fyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fyp.databinding.ActivityComputerSciSocietyRegBinding

class ComputerSciSocietyReg : AppCompatActivity() {

    private lateinit var binding: ActivityComputerSciSocietyRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityComputerSciSocietyRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed() // Takes the user back to the previous activity
        }
    }
}
