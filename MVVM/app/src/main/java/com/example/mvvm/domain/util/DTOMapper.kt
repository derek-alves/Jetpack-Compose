package com.example.mvvm.domain.util

interface DTOMapper <DTO,Model>{

    fun mapFromDTO(DTO:DTO):Model

    fun mapToDTO(domainModel: Model):DTO
}