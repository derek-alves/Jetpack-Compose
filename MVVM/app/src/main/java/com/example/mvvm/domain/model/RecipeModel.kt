package com.example.mvvm.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class RecipeModel(
    val id:Int? = null,
    val title: String? = null,
    val publisher: String? = null,
    val featuredImage:String? = null,
    val rating: Int? = 0,
    val sourceUrl: String? = null,
    val description: String? = null,
    val cookingInstructions:String? = null,
    val ingredients:List<String> = listOf(),
    val dataAdded: String? = null,
    val dateUpdated: String? = null,
    ):Parcelable