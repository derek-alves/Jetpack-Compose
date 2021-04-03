package com.example.mvvm.presentation.ui.recipe_list


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.domain.model.RecipeModel
import com.example.mvvm.respository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String,
) : ViewModel() {
    private val _recipes:MutableLiveData<List<RecipeModel>> = MutableLiveData()

    val recipes:LiveData<List<RecipeModel>> get()= _recipes

}