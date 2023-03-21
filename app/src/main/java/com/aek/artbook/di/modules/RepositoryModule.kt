package com.aek.artbook.di.modules

import com.aek.artbook.data.api.ImageService
import com.aek.artbook.data.db.ArtDao
import com.aek.artbook.data.repository.ArtRepository
import com.aek.artbook.data.repository.ArtRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideArtRepository(imageService: ImageService, artDao: ArtDao): ArtRepository {
        return ArtRepositoryImpl(imageService, artDao)
    }
}
