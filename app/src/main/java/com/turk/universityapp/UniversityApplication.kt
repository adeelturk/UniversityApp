package com.turk.universityapp

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UniversityApplication :MultiDexApplication(){
}