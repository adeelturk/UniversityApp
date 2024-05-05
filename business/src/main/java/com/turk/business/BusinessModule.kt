package com.turk.business

import com.turk.universityreposiotry.repo.UniversityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object BusinessModule {

    @Provides
    fun providesUniversityUseCase(universityRepository: UniversityRepository):UniversityUseCase{

      return  UniversityUseCase(universityRepository)
    }
}