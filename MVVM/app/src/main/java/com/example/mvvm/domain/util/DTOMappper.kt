package com.example.mvvm.domain.util

interface DTOMappper <DTO,Model>{

    fun mapFromDTO(entity:DTO):Model

    fun mapToDTO(domainModel: Model):DTO
}