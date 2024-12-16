package com.example.fyp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityComputerSocietyScreenBinding

class ComputerSocietyScreen : AppCompatActivity() {

    private lateinit var binding: ActivityComputerSocietyScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityComputerSocietyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed() // This takes the user back to the previous screen (Societies activity)
        }

        // Set up the Register text click listener to navigate to SocietyRegistrationForm
        binding.register.setOnClickListener {
            val intent = Intent(this, ComputerSciSocietyReg::class.java)
            startActivity(intent)
        }
    }
}
