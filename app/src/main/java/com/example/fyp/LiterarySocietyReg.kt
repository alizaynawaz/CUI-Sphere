package com.example.fyp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fyp.databinding.ActivityLiterarySocietyRegBinding

class LiterarySocietyReg : AppCompatActivity() {

    private lateinit var binding: ActivityLiterarySocietyRegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivityLiterarySocietyRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed() // Takes the user back to the previous activity
        }
    }
}
