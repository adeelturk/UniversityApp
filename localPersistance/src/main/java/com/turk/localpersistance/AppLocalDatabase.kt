package com.turk.localpersistance


import androidx.room.Database
import androidx.room.RoomDatabase
import com.turk.dtos.model.UniversityDbData
import com.turk.localpersistance.university.UniversityDao

@Database(entities = [UniversityDbData::class], version = 1, exportSchema = false)
abstract class AppLocalDatabase: RoomDatabase() {
    abstract fun universityDao(): UniversityDao
}