package com.example.mvvm

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvm.domain.model.RecipeModel
import com.example.mvvm.network.model.RecipeDTO
import com.example.mvvm.network.model.RecipeDTOMapper
import com.example.mvvm.ui.theme.MVVMTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Androidd")
                }
            }
        }

        val mapper = RecipeDTOMapper()

        val recipe = RecipeModel()

        val networkEntity: RecipeDTO = mapper.mapToDTO(recipe)

        val r: RecipeModel = mapper.mapFromDTO(networkEntity)



    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MVVMTheme {
        Greeting("Android")
    }
}