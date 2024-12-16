package com.example.fyp

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityMusicFesScreenBinding
import com.example.fyp.databinding.EventRegDialogBinding
import com.example.fyp.databinding.ShareDialogBinding

class MusicFesScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMusicFesScreenBinding // Binding instance for activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicFesScreenBinding.inflate(layoutInflater) // Initialize binding
        setContentView(binding.root) // Set the content view using binding

        // Register button click listener (will show Event Registration Dialog)
        binding.registerButton.setOnClickListener {
            showEventRegistrationDialog() // Show the event registration dialog
        }

        // Share button click listener (will show Share Dialog)
        binding.shareButton.setOnClickListener {
            showShareDialog() // Show the share dialog
        }
    }

    // Function to show Event Registration Dialog
    private fun showEventRegistrationDialog() {
        // Dialog binding for Event Registration
        val dialogBinding = EventRegDialogBinding.inflate(layoutInflater) // Inflate dialog layout
        val dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root) // Set the custom dialog layout

        // Initialize Views for the dialog
        val eventNameEditText = dialogBinding.eventName
        val participantNameEditText = dialogBinding.participantName
        val phoneNumberEditText = dialogBinding.phoneNumber
        val departmentEditText = dialogBinding.department

        val cancelButton = dialogBinding.cancelButton
        val submitButton = dialogBinding.submitButton
        val backArrow = dialogBinding.backArrow

        // Back button functionality
        backArrow.setOnClickListener {
            dialog.dismiss() // Close the dialog
        }

        // Cancel button functionality
        cancelButton.setOnClickListener {
            dialog.dismiss() // Close the dialog
        }

        // Submit button functionality
        submitButton.setOnClickListener {
            // Handle form submission, save data, or perform other tasks
            val eventName = eventNameEditText.text.toString()
            val participantName = participantNameEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val department = departmentEditText.text.toString()

            // Example: Show a message or handle the input data
            println("Event Name: $eventName, Participant Name: $participantName, Phone: $phoneNumber, Department: $department")

            // After submit, navigate to Event Submit Activity
            val intent = Intent(this, EventSubmit::class.java) // Replace with your Event Submit Activity
            startActivity(intent)

            // Dismiss the dialog
            dialog.dismiss()
        }

        // Show dialog
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    // Function to show Share Dialog
    private fun showShareDialog() {
        // Dialog binding for Share
        val dialogBinding = ShareDialogBinding.inflate(layoutInflater) // Inflate dialog layout
        val dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root) // Set the custom dialog layout

        // Cancel button functionality for Share Dialog
        dialogBinding.btnCancel.setOnClickListener {
            dialog.dismiss() // Close the dialog
        }

        // Show dialog
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }
}


