package com.example.fyp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityEventSubmitBinding

class EventSubmit : AppCompatActivity() {

    private lateinit var binding: ActivityEventSubmitBinding // View Binding instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventSubmitBinding.inflate(layoutInflater) // Initialize View Binding
        setContentView(binding.root) // Set the content view using binding

        // Set OnClickListener for "Search for other events" button
        binding.searchForOtherEvent.setOnClickListener {
            // Create an Intent to navigate to Event
            val intent = Intent(this, Event::class.java)
            startActivity(intent)
        }
    }
}

