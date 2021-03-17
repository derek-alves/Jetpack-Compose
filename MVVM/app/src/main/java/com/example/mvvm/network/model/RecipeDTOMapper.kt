package com.example.mvvm.network.model

import com.example.mvvm.domain.model.RecipeModel
import com.example.mvvm.domain.util.DTOMapper


class RecipeDTOMapper : DTOMapper<RecipeDTO, RecipeModel> {
    override fun mapToDomainModel(DTO: RecipeDTO): RecipeModel {
        return RecipeModel(
            id = DTO.pk,
            title = DTO.title,
            featuredImage = DTO.featuredImage,
            rating = DTO.rating,
            publisher = DTO.publisher,
            sourceUrl = DTO.sourceUrl,
            description = DTO.description,
            cookingInstructions = DTO.cookingInstructions,
            ingredients = DTO.ingredients ?: listOf(),
            dateAdded = DTO.dateAdded,
            dateUpdated = DTO.dateUpdated,
            )
    }

    override fun mapFromDomainModel(domainModel: RecipeModel): RecipeDTO {
        return RecipeDTO(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
            )
    }

    fun toDomainList(initial:List<RecipeDTO>):List<RecipeModel>{
        return initial.map { mapToDomainModel(it)}
    }

    fun toDTOList(initial:List<RecipeModel>):List<RecipeDTO>{
        return initial.map { mapFromDomainModel(it)}
    }

}