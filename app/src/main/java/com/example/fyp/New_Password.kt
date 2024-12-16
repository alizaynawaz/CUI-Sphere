package com.example.fyp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityNewPasswordBinding

class New_Password : AppCompatActivity() {

    // Declare the View Binding object
    private lateinit var binding: ActivityNewPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityNewPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the click listener for the "Send" button
        binding.sendButton.setOnClickListener {
            // After clicking "Send", navigate to Sign In screen
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)

        }
        binding.backArrow.setOnClickListener {
            onBackPressed() // Takes the user back to the previous activity
        }
    }
}
