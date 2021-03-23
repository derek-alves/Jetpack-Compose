package com.example.mvvm.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.domain.model.RecipeModel
import com.example.mvvm.network.RecipeService
import com.example.mvvm.network.model.RecipeDTO
import com.example.mvvm.network.model.RecipeDTOMapper
import com.example.mvvm.presentation.ui.recipe.RecipeView
import com.example.mvvm.presentation.ui.recipe_list.RecipeList
import com.example.mvvm.ui.theme.MVVMTheme
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,startDestination = "RecipeList"){
                    composable("RecipeList"){ RecipeList(navController = navController)}
                    composable("RecipeView"){ RecipeView()}
                }
            }
        }
    }
}









//            val service = Retrofit.Builder().baseUrl("https://food2fork.ca/api/recipe/")
//                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//                .build()
//                .create(RecipeService::class.java)
//
//           CoroutineScope(IO).launch {
//               val response = service.get(
//                   token = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
//                   583
//               )
//
//               Log.d("Response network", "onCreate:${response.title}")
//
//           }


//        val mapper = RecipeDTOMapper()
//
//        val recipe = RecipeModel()
//
//        val networkEntity: RecipeDTO = mapper.mapFromDomainModel(recipe)
//
//        val r: RecipeModel = mapper.mapToDomainModel(networkEntity)
//
//        Log.d("APP", "onCreate:$app")