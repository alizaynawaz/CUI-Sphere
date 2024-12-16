package com.example.fyp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.databinding.ItemEventBinding // Import the generated binding class for item_event.xml

// Adapter class for RecyclerView
class EventAdapter(
    private val events: List<Event>,
    private val onEventClick: (Event) -> Unit // Add a listener for item clicks
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    // ViewHolder class that holds references to the views for each item
    inner class EventViewHolder(private val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {

        // Function to bind data to the views
        fun bind(event: Event) {
            binding.eventTitle.text = event.title
            binding.eventTime.text = event.time

            // Handle item click
            binding.root.setOnClickListener {
                onEventClick(event) // Trigger the click listener when an event is clicked
            }
        }
    }

    // This function creates a ViewHolder when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    // This function binds data to the ViewHolder
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    // This function returns the total count of items
    override fun getItemCount(): Int = events.size
}

