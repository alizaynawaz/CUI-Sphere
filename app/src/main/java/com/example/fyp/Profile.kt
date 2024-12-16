package com.example.fyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fyp.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editbutton.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent) // Start the EditProfileActivity
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}

