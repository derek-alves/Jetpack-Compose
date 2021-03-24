package com.example.mvvm.presentation.ui.recipe_list


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Button
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun RecipeList(
    navController: NavController,
    viewModel: RecipeListViewModel = viewModel()
) {

    Log.d("VIEW","VIEW MODEL: $viewModel")
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "RecipeList",
            fontSize = 21.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = {
               navController.navigate("RecipeView")
            }
        ) {
           Text(text = "TO RECIPE FRAGMENT")
        }
    }
}