package com.example.HomeWork7.ui.playlistItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.HomeWork7.data.model.VideoModel
import com.example.HomeWork7.data.repository.YouTubeRepository


class VideoViewModel(private val repository: YouTubeRepository) : ViewModel() {

    fun getPlaylistVideo(getId: String, listSize: Int): LiveData<com.example.HomeWork7.utils.Resource<List<VideoModel.Item>>> =
        repository.getPlaylistVideo(getId, listSize)
}
