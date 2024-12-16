package com.example.fyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fyp.databinding.ActivitySportsSocietyRegBinding

class SportsSocietyReg : AppCompatActivity() {

    private lateinit var binding: ActivitySportsSocietyRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object
        binding = ActivitySportsSocietyRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed() // Takes the user back to the previous activity
        }
    }
}
