package com.example.fyp

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent // Add this import
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp.databinding.ActivityEventBinding
import com.example.fyp.databinding.DialogFilterBinding
import java.util.*


class EventActivity : AppCompatActivity() {

    // Declare a binding variable for the activity
    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding by inflating the layout
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView with LinearLayoutManager and adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val eventList = listOf(
            Event("Music Festival", "15 July - Wed", "2:00PM"),
            Event("Youth Drama", "15 July - Wed", "2:00PM"),
            Event("Women's Leadership Conference", "15 July - Wed", "2:00PM"),
            Event("International Kids Safe Parents Night Out", "15 July - Wed", "2:00PM"),
            Event("Punjabi Mushaira", "15 July - Wed", "2:00PM")
        )


        // Set the adapter with a click listener for event items
        binding.recyclerView.adapter = EventAdapter(eventList) { event ->
            // Handle event click
            if (event.title == "Music Festival") {
                // Open MusicFesScreen when Music Festival is clicked
                val intent = Intent(this, MusicFesScreen::class.java)
                startActivity(intent)
            } else {
                // Show a simple toast for other events
                Toast.makeText(this, "Clicked on ${event.title}", Toast.LENGTH_SHORT).show()
            }
        }

        // Set back button action
        binding.backArrow.setOnClickListener {
            onBackPressed()
        }

        // Set up the filter dialog button
        binding.openFilterDialogButton.setOnClickListener {
            showFilterDialog()
        }
    }

    private fun showFilterDialog() {
        // Initialize view binding for the dialog layout
        val dialogBinding = DialogFilterBinding.inflate(layoutInflater)

        // Create and configure the dialog
        val dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // Set the dialog width and height to match the parent
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        // Set up button listeners in the dialog using view binding
        dialogBinding.resetButton.setOnClickListener {
            // Reset action
            dialog.dismiss()
        }

        dialogBinding.applyButton.setOnClickListener {
            // Apply action
            dialog.dismiss()
        }

        // Set up "Choose from calendar" click listener
        dialogBinding.calendarOption.setOnClickListener {
            // Display a DatePickerDialog
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Update the TextView with the selected date
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    dialogBinding.calendarTextView.text = selectedDate // Assuming you have a TextView to show the selected date
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        // Show the dialog
        dialog.show()
    }
}

