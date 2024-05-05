package com.turk.universityreposiotry.datasource

import android.util.Log
import com.turk.common.error.ErrorEntity
import com.turk.common.functional.Either
import com.turk.dtos.mapper.UniversityDataMapper
import com.turk.dtos.model.University
import com.turk.localpersistance.university.UniversityDao
import com.turk.common.extension.asEither
import com.turk.dtos.model.UniversityDbData
import com.turk.network.requestBlockingFlow
import com.turk.universityreposiotry.UniversityApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UniversityDataSourceImpl @Inject constructor(
    private val universityService:UniversityApiService,
    private val mapper: UniversityDataMapper,
    private val dao: UniversityDao
    ):UniversityDataSource{
   override fun getUniversities():
           Flow<Either<ErrorEntity,List<University>>> {
     return  flow {

         emit( universityService.getUniversities("turkey").map {

             mapper.mapToDbModel(it)
          })

       }.onEach {

           flow{
               dao.insert(it)
               emit( dao.getAllUniversities())
           }

      }.asEither{
          mapper.mapToDomainModel(it)
     }

   }

}