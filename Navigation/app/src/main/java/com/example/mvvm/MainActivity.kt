package com.example.mvvm

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.ui.theme.MVVMTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMTheme {
                    val NavController = rememberNavController()
                    NavHost(navController = NavController, startDestination = "Main" ){
                        composable("Main") {RecipeFragment(NavController)}
                        composable("second"){RecipeListFragment()}
                        composable("listScreen"){ ListScreen(navController = NavController)}
                        composable("details/{name}"){ backStackEntry ->
                            Detail_screen(
                                NavController,
                                backStackEntry.arguments?.getString("name")?:"me")
                        }
                }
            }
        }
    }
}

