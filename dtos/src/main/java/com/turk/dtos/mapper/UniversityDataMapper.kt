package com.turk.dtos.mapper

import com.turk.dtos.model.University
import com.turk.dtos.model.UniversityDbData
import com.turk.dtos.model.UniversityEntity
import javax.inject.Inject

class UniversityDataMapper @Inject constructor() : DataMapper<UniversityEntity, UniversityDbData, University>() {

    override fun mapToDbModel(entity: UniversityEntity): UniversityDbData {
        return entity.run {

            UniversityDbData(
                universityCode = code,
                name = name,
                country = country,
                state = state,
                websites = webPages?.joinToString {
                    "$it " }?:""
            )
        }

    }

    override fun mapToDomainModel(dbModel: UniversityDbData): University {
        return dbModel.run {
            University(
                universityCode,
                name,
                country,
                websites,
                state
            )
        }
    }


}