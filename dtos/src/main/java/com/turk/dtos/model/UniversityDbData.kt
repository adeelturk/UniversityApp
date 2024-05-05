package com.turk.dtos.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UniversityDbData(@PrimaryKey(autoGenerate = true)
                            val id:Long=0,
                            val universityCode:String,
                            val name: String,
                            val country: String,
                            val state: String?,
                            val websites: String
                          )
