package com.example.fyp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Set the layout for the splash screen
        setContentView(R.layout.activity_main)

        // Add a delay of 3 seconds (3000 milliseconds) to show the splash screen
        Handler().postDelayed({
            // Check if the user is already signed in
            val currentUser = auth.currentUser

            // If the user is signed in, navigate to the HomeScreen
            if (currentUser != null) {
                // Start the HomeScreen activity
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
            } else {
                // If the user is not signed in, navigate to the SignUp activity
                val intent = Intent(this, SignUp::class.java)
                startActivity(intent)
            }

            // Finish MainActivity so it won't stay in the back stack
            finish()

        }, 3000)  // 3000 milliseconds = 3 seconds
    }
}



