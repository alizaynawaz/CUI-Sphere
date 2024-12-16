package com.example.fyp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.databinding.ItemPostBinding

class PostAdapter(private val postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    // Listener for comment clicks
    var onCommentClickListener: ((Post) -> Unit)? = null

    // Listener for share clicks
    var onShareClickListener: ((Post) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.bind(post)
    }

    override fun getItemCount() = postList.size

    inner class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            // Set image and description
            binding.postImage.setImageResource(post.imageResId)
            binding.postDescription.text = post.description

            // Set the like icon based on the current like status
            binding.likeIcon.setImageResource(if (post.isLiked) R.drawable.like_ic_filled else R.drawable.like_ic)

            // Like icon click listener to toggle like status
            binding.likeIcon.setOnClickListener {
                post.isLiked = !post.isLiked // Toggle like status
                notifyItemChanged(adapterPosition) // Refresh UI
            }

            // Comment icon click listener
            binding.commentIcon.setOnClickListener {
                onCommentClickListener?.invoke(post) // Trigger the callback with the clicked post
            }

            // Share icon click listener
            binding.shareIcon.setOnClickListener {
                onShareClickListener?.invoke(post) // Trigger the callback with the clicked post
            }
        }
    }
}






