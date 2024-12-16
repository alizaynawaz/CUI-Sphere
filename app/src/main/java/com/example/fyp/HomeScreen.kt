package com.example.fyp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Create a list of posts
        val postList = listOf(
            Post(R.drawable.sample_image, "Arthur Hazan What a pleasure to meet my Web 2 students again! They have progressed so much since last year! #Proud", R.drawable.like_ic, R.drawable.comment_ic, R.drawable.share_ic),
            Post(R.drawable.festival_image, "Arthur Hazan What a pleasure to meet my Web 2 students again! They have progressed so much since last year! #Proud", R.drawable.like_ic, R.drawable.comment_ic, R.drawable.share_ic),
            Post(R.drawable.cs_image, "Arthur Hazan What a pleasure to meet my Web 2 students again! They have progressed so much since last year! #Proud", R.drawable.like_ic, R.drawable.comment_ic, R.drawable.share_ic),
            Post(R.drawable.cds_image, "Arthur Hazan What a pleasure to meet my Web 2 students again! They have progressed so much since last year! #Proud", R.drawable.like_ic, R.drawable.comment_ic, R.drawable.share_ic),
            Post(R.drawable.media_image, "Arthur Hazan What a pleasure to meet my Web 2 students again! They have progressed so much since last year! #Proud", R.drawable.like_ic, R.drawable.comment_ic, R.drawable.share_ic)
        )

        // Initialize the adapter with comment and share listeners
        postAdapter = PostAdapter(postList).apply {
            onCommentClickListener = { post ->
                // Navigate to the CommentScreen
                val intent = Intent(this@HomeScreen, CommentScreen::class.java)
                intent.putExtra("post_id", post.commentIconResId) // Optional: pass post-specific data
                startActivity(intent)
            }

            onShareClickListener = { post ->
                // Show share dialog
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "Check out this post: ${post.description}")
                }
                startActivity(Intent.createChooser(shareIntent, "Share Post"))
            }
        }

        // Set the adapter to RecyclerView
        binding.recyclerView.adapter = postAdapter

        // Handle Drawer Toggle (Open/Close)
        binding.iconMenu.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                binding.drawerLayout.closeDrawer(Gravity.LEFT)
            } else {
                binding.drawerLayout.openDrawer(Gravity.LEFT)
            }
        }

        // Set Navigation Drawer Item Selection
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_feeds -> true // Already on Feeds screen
                R.id.nav_Societies -> {
                    startActivity(Intent(this, Societies::class.java))
                    true
                }
                R.id.menu_schedule -> {
                    startActivity(Intent(this, Schedule::class.java))
                    true
                }
                R.id.menu_help -> {
                    startActivity(Intent(this, FAQScreen::class.java))
                    true
                }
                R.id.menu_settings -> {
                    startActivity(Intent(this, Setting::class.java))
                    true
                }
                R.id.menu_profile -> {
                    startActivity(Intent(this, Profile::class.java))
                    true
                }
                R.id.menu_notifications -> {
                    startActivity(Intent(this, NotificationScreen::class.java))
                    true
                }
                R.id.menu_sign_out -> {
                    startActivity(Intent(this, SignIn::class.java))
                    true
                }
                else -> false
            }
        }

        // Set up Bottom Navigation
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_feeds -> {
                    startActivity(Intent(this, HomeScreen::class.java))
                    true
                }
                R.id.nav_Societies -> {
                    startActivity(Intent(this, Societies::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, Profile::class.java))
                    true
                }
                R.id.nav_Events -> {
                    startActivity(Intent(this, EventActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}










