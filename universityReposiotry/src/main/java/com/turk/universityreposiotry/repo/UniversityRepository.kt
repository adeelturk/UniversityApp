package com.turk.universityreposiotry.repo

import com.turk.common.error.ErrorEntity
import com.turk.common.functional.Either
import com.turk.dtos.model.University
import kotlinx.coroutines.flow.Flow

interface UniversityRepository {

    fun getUniversities():Flow<Either<ErrorEntity,List<University>>>

}