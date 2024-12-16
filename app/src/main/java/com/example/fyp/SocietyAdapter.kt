package com.example.fyp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.databinding.SocietyItemBinding // Adjust the import based on your package

class SocietyAdapter(private val societyList: List<Society>, private val onItemClick: (Society) -> Unit) :
    RecyclerView.Adapter<SocietyAdapter.SocietyViewHolder>() {

    // ViewHolder: Holds the views for each item using View Binding
    class SocietyViewHolder(private val binding: SocietyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(society: Society, onItemClick: (Society) -> Unit) {
            binding.sportsSocietyLogo.setImageResource(society.imageResId)
            binding.sportsSocietyName.text = society.name
            // Set click listener for the item
            binding.root.setOnClickListener { onItemClick(society) }
        }
    }

    // Called to create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SocietyViewHolder {
        val binding = SocietyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SocietyViewHolder(binding)
    }

    // Called to bind data to the views
    override fun onBindViewHolder(holder: SocietyViewHolder, position: Int) {
        val society = societyList[position]
        holder.bind(society, onItemClick)
    }

    // Returns the size of the list
    override fun getItemCount(): Int = societyList.size
}

