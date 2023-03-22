package com.aek.artbook.di.modules

import com.aek.artbook.data.db.ArtDao
import com.aek.artbook.data.service.ImageService
import com.aek.artbook.data.source.local.LocalDataSource
import com.aek.artbook.data.source.local.LocalDataSourceImpl
import com.aek.artbook.data.source.remote.RemoteDataSource
import com.aek.artbook.data.source.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(imageService: ImageService): RemoteDataSource {
        return RemoteDataSourceImpl(imageService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(dao: ArtDao): LocalDataSource {
        return LocalDataSourceImpl(dao)
    }
}
