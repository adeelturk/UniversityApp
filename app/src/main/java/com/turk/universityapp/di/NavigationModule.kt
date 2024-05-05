package com.turk.universityapp.di

import com.turk.universityapp.nav.Navigator
import com.turk.universitydetails.nav.UniversityDetailsNav
import com.turk.universitylisting.nav.UniversityListNav
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
   @Singleton
    fun provideUniversityListNav(navigator:Navigator): UniversityListNav = navigator

    @Provides
    @Singleton
    fun UniversityDetailsNav(navigator:Navigator): UniversityDetailsNav  = navigator

    @Provides
    @Singleton
    fun providesNavigator(): Navigator {
        return Navigator()
    }


}