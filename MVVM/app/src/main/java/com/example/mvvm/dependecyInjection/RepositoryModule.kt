package com.example.mvvm.dependecyInjection

import com.example.mvvm.network.RecipeService
import com.example.mvvm.network.model.RecipeDTOMapper
import com.example.mvvm.respository.RecipeRepository
import com.example.mvvm.respository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDTOMapper: RecipeDTOMapper
    ):RecipeRepository{
        return RecipeRepository_Impl(recipeService,recipeDTOMapper)
    }
}