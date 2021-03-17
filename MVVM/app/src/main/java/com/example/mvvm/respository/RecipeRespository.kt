package com.example.mvvm.respository

import com.example.mvvm.domain.model.RecipeModel

interface RecipeRepository {
    suspend fun search (token:String, page:Int, query:String):List<RecipeModel>

    suspend fun get(token:String,id: Int):RecipeModel
}