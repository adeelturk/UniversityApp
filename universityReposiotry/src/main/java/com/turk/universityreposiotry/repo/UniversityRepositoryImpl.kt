package com.turk.universityreposiotry.repo

import com.turk.common.error.ErrorEntity
import com.turk.common.functional.Either
import com.turk.dtos.model.University
import com.turk.universityreposiotry.datasource.UniversityDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UniversityRepositoryImpl @Inject constructor(
    private val dataSource: UniversityDataSource):UniversityRepository{
    override fun getUniversities():Flow<Either<ErrorEntity,List<University>>> =
    dataSource.getUniversities()

}