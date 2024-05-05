package com.turk.dtos.mapper

/**
 * Provide the Implementation to map Network Dto to Db Dto and DbDto to AppDto
 * [Entity] is Variant for Network Dto
 * [DbModel] is  Variant for Local  Database
 * [DomainModel] is  Variant for App Dto
 */

abstract class DataMapper<Entity,DbModel,DomainModel> {


   abstract fun mapToDbModel(entity:Entity):DbModel

    abstract fun mapToDomainModel(dbModel:DbModel):DomainModel

    fun mapToDbModel(entityList: List<Entity>): List<DbModel> {

        return entityList.map {

            mapToDbModel(it)
        }
    }

    fun mapToDomainModel(cacheDataList: List<DbModel>): List<DomainModel> {
        return cacheDataList.map {

            mapToDomainModel(it)
        }

    }

}