package com.example.mvvm.respository

import com.example.mvvm.domain.model.RecipeModel

import com.example.mvvm.network.RecipeService
import com.example.mvvm.network.model.RecipeDTOMapper

class RecipeRepository_Impl(
    private val recipeService: RecipeService,
    private val mapper:RecipeDTOMapper
    ):RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String):
            List<RecipeModel> {
                 return mapper.toDomainList(recipeService.search(token,page,query).recipes)
    }

    override suspend fun get(token: String, id: Int): RecipeModel {
        return mapper.mapToDomainModel(recipeService.get(token,id))
    }
}