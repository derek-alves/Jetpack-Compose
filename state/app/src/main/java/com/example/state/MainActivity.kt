package com.example.state

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.state.ui.theme.StateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var count by remember { mutableStateOf(0) }
                    MyButton(count) { count = it + 1 }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateTheme {
        MyButton(0) { 0 + 1 }
    }
}


@Composable
fun MyButton(currentCount:Int, updateCount:(Int)-> Unit) {

    Button(
        onClick = {
            updateCount(currentCount)
        }, contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White,
        )
    ) {
        Text(
            text = "Count is: $currentCount",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(5.dp)
        )

    }
}


@Composable
fun MyButtonStateful() {
    val context = LocalContext.current
    var count by remember { mutableStateOf(0) }
    Button(
        onClick = {
            count += 1
            Toast.makeText(context, "Count is: $count", Toast.LENGTH_SHORT).show()
        }, contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White,
        )
    ) {
        Text(
            text = "Count is: $count",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(5.dp)
        )

    }
}

