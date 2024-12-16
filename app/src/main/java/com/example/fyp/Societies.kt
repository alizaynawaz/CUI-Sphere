package com.example.fyp

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fyp.databinding.ActivitySocietiesBinding

class Societies : AppCompatActivity() {

    private lateinit var binding: ActivitySocietiesBinding
    private lateinit var societyAdapter: SocietyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySocietiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconBack.setOnClickListener {
            onBackPressed() // Takes the user back to the previous activity
        }


        // Set up RecyclerView
        binding.recyclerViewSocieties.layoutManager = GridLayoutManager(this, 2)

        // Set up adapter with item click listener
        societyAdapter = SocietyAdapter(getSocietyList()) { society ->
            // Check the clicked society's name and navigate accordingly
            when (society.name) {
                "Sports Society" -> {
                    // Navigate to SportsSocietyScreen
                    val intent = Intent(this, SportsSocietyScreen::class.java)
                    startActivity(intent)
                }
                "Computer Science Society" -> {
                    // Navigate to ComputerSocietyScreen
                    val intent = Intent(this, ComputerSocietyScreen::class.java)
                    startActivity(intent)
                }
                "Literary Society" -> {
                    // Navigate to LiterarySocietyScreen
                    val intent = Intent(this, LiterarySocietyScreen::class.java)
                    startActivity(intent)
                }
                "Dramatic Society" -> {
                    // Navigate to DramaSocietyScreen
                    val intent = Intent(this, DramaSocietyScreen::class.java)
                    startActivity(intent)
                }
                "Media & Publicity Society" -> {
                    // Navigate to MediaSocietyScreen
                    val intent = Intent(this, MediaSocietyScreen::class.java)
                    startActivity(intent)
                }
                "Horticulture Society" -> {
                    // Navigate to HorticultureSocietyScreen
                    val intent = Intent(this, HorticultureSocietyScreen::class.java)
                    startActivity(intent)
                }
            }
        }
        binding.recyclerViewSocieties.adapter = societyAdapter
    }

    private fun getSocietyList(): List<Society> {
        return listOf(
            Society(R.drawable.sports_society, "Sports Society"),
            Society(R.drawable.computer_science_society, "Computer Science Society"),
            Society(R.drawable.literary_society, "Literary Society"),
            Society(R.drawable.dramatic_society, "Dramatic Society"),
            Society(R.drawable.media_society, "Media & Publicity Society"),
            Society(R.drawable.horticulture_society, "Horticulture Society")
        )
    }
}




