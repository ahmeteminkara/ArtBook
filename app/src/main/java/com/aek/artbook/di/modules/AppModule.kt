package com.aek.artbook.di.modules

import android.content.Context
import androidx.room.Room
import com.aek.artbook.constants.AppConstants
import com.aek.artbook.data.db.ArtDao
import com.aek.artbook.data.db.ArtDatabase
import com.aek.artbook.data.db.RoomMigrations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): ArtDatabase {
        return Room.databaseBuilder(context, ArtDatabase::class.java, "art-db")
            .fallbackToDestructiveMigration()
            .addMigrations(
                RoomMigrations.MIGRATION_1_2
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideArtDao(artDatabase: ArtDatabase): ArtDao {
        return artDatabase.artDao()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.Service.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
