package com.example.HomeWork7.data.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.HomeWork7.BuildConfig
import kotlinx.coroutines.Dispatchers
import com.example.HomeWork7.data.api.YouTubeApiService
import com.example.HomeWork7.data.model.BaseResponse
import com.example.HomeWork7.data.model.VideoModel
import com.example.HomeWork7.utils.Constant
import com.example.HomeWork7.utils.Resource

class YouTubeRepository(
    private val service: YouTubeApiService
) {

    fun getPlaylists(): LiveData<Resource<List<BaseResponse.Item>>> = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            val response = service.getPlaylists(
                apiKey = BuildConfig.API_KEY,
                part = Constant.PART,
                channelId = Constant.CHANNEL_ID,
                maxResults = Constant.MAX_RESULTS
            )
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it.items))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        }
    }

    fun getPlaylistVideo(playlistId: String, listSize:Int): LiveData<Resource<List<VideoModel.Item>>> =
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = service.getPlaylistItems(
                    apiKey = BuildConfig.API_KEY,
                    part = Constant.PART,
                    playlistId = playlistId,
                    maxResults = listSize
                )
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(Resource.Success(it.items))
                    }
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
            }
        }

}