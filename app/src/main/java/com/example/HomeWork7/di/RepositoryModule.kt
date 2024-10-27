package com.example.HomeWork7.di

import com.example.HomeWork7.data.repository.YouTubeRepository
import org.koin.dsl.module

val repositoryModule = module {

    single {
        YouTubeRepository(get())
    }
}