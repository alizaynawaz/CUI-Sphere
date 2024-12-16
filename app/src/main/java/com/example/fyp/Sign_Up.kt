package com.example.fyp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    // Declare the View Binding object
    private lateinit var binding: ActivitySignUpBinding

    // Declare Firebase Auth instance
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Set up the click listener for the "Sign Up" button
        binding.signUpButton.setOnClickListener {
            // Get user input
            val fullName = binding.etFullName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.password.text.toString()
            val confirmPassword = binding.confirmPassword.text.toString()

            // Validate user inputs
            if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else if (password.length < 6) {
                Toast.makeText(this, "Password should be at least 6 characters", Toast.LENGTH_SHORT).show()
            } else {
                // Proceed with Firebase Authentication
                createUserWithEmailAndPassword(email, password)
            }
        }

        // Set up the click listener for the "Login" TextView
        binding.login.setOnClickListener {
            // Navigate to Sign In Activity
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }

    // Firebase sign-up logic
    private fun createUserWithEmailAndPassword(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign-up successful
                    Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()

                    // Redirect to Sign-In Activity
                    val intent = Intent(this, SignIn::class.java)
                    startActivity(intent)
                    finish() // Close Sign Up Activity
                } else {
                    // Sign-up failed
                    Toast.makeText(this, "Sign Up Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

