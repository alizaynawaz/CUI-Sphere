package com.example.fyp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityDramaSocietyScreenBinding


class DramaSocietyScreen : AppCompatActivity() {

    private lateinit var binding: ActivityDramaSocietyScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityDramaSocietyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed()  // Navigate back to the previous screen (Societies activity)
        }
        binding.register.setOnClickListener {
            val intent = Intent(this, DramaticSocietyReg::class.java)
            startActivity(intent)

        }
    }
}
