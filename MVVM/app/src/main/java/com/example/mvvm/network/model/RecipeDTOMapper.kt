package com.example.mvvm.network.model

import com.example.mvvm.domain.model.RecipeModel
import com.example.mvvm.domain.util.DTOMappper

class RecipeDTOMapper:DTOMappper<RecipeDTO,RecipeModel>{
    override fun mapFromDTO(entity: RecipeDTO): RecipeModel {
        TODO("Not yet implemented")
    }

    override fun mapToDTO(domainModel: RecipeModel): RecipeDTO {
        TODO("Not yet implemented")
    }

}