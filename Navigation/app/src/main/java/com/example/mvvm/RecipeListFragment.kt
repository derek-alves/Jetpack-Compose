package com.example.mvvm


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecipeListFragment() {
Column() {
    Text(text = "Recipe",Modifier.clickable {  })
    Text(text = "aaaaaaaaaa")
    Text(text = "Rebbbbbbbbc")
    Text(text = "Recipeccccccc")
    Text(text = "Recivvvvvvpe")
    Text(text = "Reciccccpe")
   Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(Color.Red)) {
       Text(text = "Marcelo")
   }
}
}

@Preview
@Composable
fun Preview(){
    RecipeListFragment()
}
