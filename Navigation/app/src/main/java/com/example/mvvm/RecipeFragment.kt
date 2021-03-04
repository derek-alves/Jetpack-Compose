package com.example.mvvm

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun RecipeFragment(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "First AppBar") },actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
            }
        }
        )
    }) {
        BodyContent(navController = navController)
    }
}


@Composable
fun BodyContent(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Card(Modifier.clickable(onClick = { navController.navigate("listScreen") })) {
                Row() {
                    Surface(
                        Modifier.size(50.dp),
                        shape = CircleShape,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)

                    ) {
                        Text(
                            text = "OLA",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center
                        )
                    }
                    Column() {
                        Text("Testando", fontWeight = FontWeight.Bold)
                        Text("Online", style = MaterialTheme.typography.body2)
                    }
                }


            }
            Card(Modifier.padding(10.dp)) {
                Text(text = "Segundo Card")
            }
        }
        Button(onClick = { navController.navigate("second") }) {
            Text(text = "Go to next")
        }
    }
}