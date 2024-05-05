package com.turk.localpersistance.university

import androidx.room.Dao
import androidx.room.Query
import com.turk.dtos.model.UniversityDbData
import com.turk.localpersistance.BaseDao
import kotlinx.coroutines.flow.Flow


@Dao
interface UniversityDao:BaseDao<UniversityDbData> {
    @Query("SELECT * FROM UniversityDbData")
     fun getAllUniversities(): Flow<List<UniversityDbData>>

}