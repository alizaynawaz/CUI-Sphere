package com.example.fyp

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.databinding.ActivityEditProfileBinding
import java.util.Calendar

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        // Save button functionality
        binding.saveButton.setOnClickListener {
            saveChanges()
        }

        // Camera icon functionality
        binding.cameraIcon.setOnClickListener {
            Toast.makeText(this, "Camera icon clicked", Toast.LENGTH_SHORT).show()
        }

        // Set a click listener for the Date of Birth field to open a date picker
        binding.dobField.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun saveChanges() {
        val name = binding.nameField.text.toString()
        val email = binding.emailField.text.toString()
        val password = binding.passwordField.text.toString()
        val dob = binding.dobField.text.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Implement actual saving logic here (e.g., saving to a database)
        Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show()
    }

    private fun showDatePickerDialog() {
        // Create a Calendar instance to get the current date
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Create and show the DatePickerDialog
        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            // Format the selected date as "dd/MM/yyyy"
            val selectedDate = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
            binding.dobField.setText(selectedDate) // Set the selected date in the dobField
        }, year, month, day)

        datePickerDialog.show()
    }
}





