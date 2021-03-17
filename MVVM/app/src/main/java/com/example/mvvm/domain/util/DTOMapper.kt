package com.example.mvvm.domain.util

interface DTOMapper <T,DomainModel>{

    fun mapToDomainModel(DTO:T):DomainModel

    fun mapFromDomainModel(domainModel: DomainModel):T
}