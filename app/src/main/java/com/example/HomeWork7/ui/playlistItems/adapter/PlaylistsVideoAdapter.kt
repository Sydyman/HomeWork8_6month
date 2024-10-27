package com.example.HomeWork7.ui.playlistItems.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.HomeWork7.data.model.VideoModel
import com.example.HomeWork7.databinding.ItemVideoBinding

class PlaylistsVideoAdapter :
    ListAdapter<VideoModel.Item, PlaylistsVideoViewHolder>(PlaylistVideoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsVideoViewHolder {
        return PlaylistsVideoViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistsVideoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class PlaylistsVideoViewHolder(private val binding: ItemVideoBinding) : ViewHolder(binding.root) {
    fun bind(model: VideoModel.Item) = with(binding){
        tvTitle.text = model.snippet.title
        Glide.with(image).load(model.snippet.thumbnails.default.url).into(image)
    }
}

class PlaylistVideoDiffCallback : DiffUtil.ItemCallback<VideoModel.Item>() {
    override fun areItemsTheSame(oldItem: VideoModel.Item, newItem: VideoModel.Item) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: VideoModel.Item, newItem: VideoModel.Item) =
        oldItem == newItem

}