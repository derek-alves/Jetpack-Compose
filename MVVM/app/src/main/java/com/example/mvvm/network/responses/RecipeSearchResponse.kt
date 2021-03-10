package com.example.mvvm.network.responses

import com.example.mvvm.network.model.RecipeDTO
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDTO>
)