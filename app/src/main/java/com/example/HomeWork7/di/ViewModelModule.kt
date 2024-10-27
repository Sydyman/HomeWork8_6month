package com.example.HomeWork7.di

import com.example.HomeWork7.ui.playlistItems.VideoViewModel
import com.example.HomeWork7.ui.playlists.PlaylistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PlaylistsViewModel(get())
    }

    viewModel {
        VideoViewModel(get())
    }
}