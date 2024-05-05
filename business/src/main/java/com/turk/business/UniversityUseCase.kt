package com.turk.business

import com.turk.common.error.ErrorEntity
import com.turk.common.functional.Either
import com.turk.dtos.model.University
import com.turk.universityreposiotry.repo.UniversityRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UniversityUseCase @Inject constructor(private val universityRepository: UniversityRepository) {

    operator fun invoke(): Flow<Either<ErrorEntity, List<University>>> {
      return  universityRepository.getUniversities()
    }
}