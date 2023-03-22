package com.aek.artbook.di.modules

import com.aek.artbook.data.repository.ArtRepository
import com.aek.artbook.data.repository.ArtRepositoryImpl
import com.aek.artbook.data.source.local.LocalDataSource
import com.aek.artbook.data.source.remote.RemoteDataSource
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
    fun provideArtRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): ArtRepository {
        return ArtRepositoryImpl(remoteDataSource, localDataSource)
    }
}
