package com.example.fyp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivitySportsSocietyScreenBinding

class
SportsSocietyScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySportsSocietyScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivitySportsSocietyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed()  // Navigate back to the previous screen (Societies activity)
        }

        // Set up the Register text click listener to navigate to SocietyRegistrationForm
        binding.register.setOnClickListener {
            val intent = Intent(this, SportsSocietyReg::class.java)
            startActivity(intent)
        }
    }
}
