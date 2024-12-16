package com.example.fyp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityForgotPasswordBinding

class Forgot_Password : AppCompatActivity() {

    // Declare the View Binding object
    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the click listener for the "Send" button
        binding.sendButton.setOnClickListener {
            // After clicking "Send", navigate to Verification Password screen
            val intent = Intent(this, Verify_Password::class.java)
            startActivity(intent)
        }
        binding.backArrow.setOnClickListener {
            onBackPressed() // Takes the user back to the previous activity
        }
    }
}
