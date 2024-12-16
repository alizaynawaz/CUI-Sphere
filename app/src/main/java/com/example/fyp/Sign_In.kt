package com.example.fyp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {

    // Declare the View Binding object
    private lateinit var binding: ActivitySignInBinding

    // Declare Firebase Auth instance
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Set up click listener for the Login Button
        binding.btnLogin.setOnClickListener {
            // Get user input
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            // Validate the inputs
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
            } else {
                // Sign in with Firebase Authentication
                signInWithEmailPassword(email, password)
            }
        }

        // Set up click listener for the "Sign up" TextView
        binding.tvSignUp.setOnClickListener {
            // Navigate to Sign Up Activity
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        // Set up click listener for "Forget Password" TextView
        binding.tvForgetPassword.setOnClickListener {
            // Implement password reset logic here
            resetPassword(binding.etEmail.text.toString())
        }
    }

    // Sign-in method with Firebase
    private fun signInWithEmailPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign-in successful
                    Toast.makeText(this, "Sign In Successful", Toast.LENGTH_SHORT).show()

                    // Navigate to the Home Activity after successful login
                    val intent = Intent(this, HomeScreen::class.java)
                    startActivity(intent)
                    finish() // Close the Sign-In Activity
                } else {
                    // Sign-in failed
                    Toast.makeText(this, "Sign In Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    // Reset password method
    private fun resetPassword(email: String) {
        if (email.isEmpty()) {
            Toast.makeText(this, "Please enter your email to reset password", Toast.LENGTH_SHORT).show()
            return
        }

        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Password reset email sent
                    Toast.makeText(this, "Password reset email sent", Toast.LENGTH_SHORT).show()
                } else {
                    // Failed to send password reset email
                    Toast.makeText(this, "Failed to send reset email: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}


