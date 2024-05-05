package com.turk.localpersistance

import android.content.Context
import androidx.room.Room
import com.turk.localpersistance.university.UniversityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalPersistanceBeans {

    @Singleton
    @Provides
    fun provideUniversityDatabase(@ApplicationContext context: Context): AppLocalDatabase =
        Room.databaseBuilder(
            context,
            AppLocalDatabase::class.java,
            "universityDB"
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideUniversityDao(database: AppLocalDatabase): UniversityDao =
        database.universityDao()

}
