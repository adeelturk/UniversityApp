package com.turk.universityreposiotry

import com.turk.dtos.mapper.UniversityDataMapper
import com.turk.localpersistance.university.UniversityDao
import com.turk.universityreposiotry.datasource.UniversityDataSource
import com.turk.universityreposiotry.datasource.UniversityDataSourceImpl
import com.turk.universityreposiotry.repo.UniversityRepository
import com.turk.universityreposiotry.repo.UniversityRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UniversityRepoModule {


    @Provides
    fun providesUniversityDataSource(
        universityService:UniversityApiService,
        hotelRequestMapper: UniversityDataMapper,
        universityDao: UniversityDao
    ): UniversityDataSource {
        return UniversityDataSourceImpl( universityService,hotelRequestMapper, universityDao)
    }


    @Provides
    fun providesUniversityRepository(universityDataSource: UniversityDataSource): UniversityRepository {

        return UniversityRepositoryImpl(universityDataSource)
    }

    @Provides
    @Singleton
    fun provideUniversityApiService(retrofit: Retrofit): UniversityApiService {
        return retrofit.create(UniversityApiService::class.java)
    }

}