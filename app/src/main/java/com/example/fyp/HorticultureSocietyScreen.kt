package com.example.fyp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityHorticultureSocietyScreenBinding

class HorticultureSocietyScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHorticultureSocietyScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityHorticultureSocietyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up back arrow click listener
        binding.backArrow.setOnClickListener {
            onBackPressed()  // This will take the user back to the previous activity (Societies)
        }
        binding.register.setOnClickListener {
            val intent = Intent(this, HorticultureSocietyReg::class.java)
            startActivity(intent)
        }
    }
}
