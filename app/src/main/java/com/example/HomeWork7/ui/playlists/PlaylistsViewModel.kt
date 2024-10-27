package com.example.HomeWork7.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.HomeWork7.data.model.BaseResponse
import com.example.HomeWork7.data.repository.YouTubeRepository
import com.example.HomeWork7.utils.Resource

class PlaylistsViewModel(private val repository: YouTubeRepository): ViewModel() {

    fun getPlaylists(): LiveData<Resource<List<BaseResponse.Item>>> = repository.getPlaylists()

}