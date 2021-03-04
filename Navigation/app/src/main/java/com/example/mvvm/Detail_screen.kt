package com.example.mvvm

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun ListScreen(navController: NavHostController){
    val names = listOf("Nelson","Derek","Marcia","paulo")
    LazyColumn(content = { items(names){
        name -> Text(text = name,
        modifier = Modifier.clickable(onClick = {navController.navigate("details/$name")}))
    } })


}



@Composable
fun Detail_screen(NavController: NavHostController, name: String) {
    Column() {
        Text(text = "Details screen: $name")
        Button(onClick = { NavController.popBackStack() },
            modifier = Modifier.padding(horizontal = 5.dp,vertical = 15.dp),
        ) {
            Text(text = "Navigate Back", style = MaterialTheme.typography.button)

        }
    }


}