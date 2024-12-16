package com.example.fyp

import android.content.Intent // Add this import
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityLiterarySocietyScreenBinding

class LiterarySocietyScreen : AppCompatActivity() {

    private lateinit var binding: ActivityLiterarySocietyScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityLiterarySocietyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the Register text click listener to navigate to SocietyRegistrationForm
        binding.register.setOnClickListener {
            val intent = Intent(this, LiterarySocietyReg::class.java)
            startActivity(intent)
        }

        // Set up the back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed() // Takes the user back to the previous screen
        }
    }
}


