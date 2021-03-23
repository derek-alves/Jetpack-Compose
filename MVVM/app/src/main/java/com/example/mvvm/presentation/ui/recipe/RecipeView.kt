package com.example.mvvm.presentation.ui.recipe

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecipeView() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "This is Recipe Fragment",
            fontSize = 30.sp
            )

    }
}
