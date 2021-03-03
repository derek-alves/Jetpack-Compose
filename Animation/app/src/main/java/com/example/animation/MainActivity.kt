package com.example.animation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animation.ui.theme.AnimationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val animateState = remember{ mutableStateOf(false)}
            BoxWithConstraints(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)) {
                Rocket(maxHeight,maxWidth,isRocketEnabled = animateState.value)
                LaunchButton(
                    animateState = animateState.value,
                    onToggleAnimationState = {
                        animateState.value = !animateState.value})
            }
        }
    }
}

@Composable
fun Rocket(maxHeight: Dp, maxWidth:Dp,isRocketEnabled:Boolean){
    val resource: Painter
    val modifier:Modifier
    val rocketSize = 200.dp
    if(!isRocketEnabled){
        resource = painterResource(id = R.drawable.rocket_intial)
        modifier = Modifier.offset(
            y = maxHeight - rocketSize
        )
    }else{
        val infiniteTransition = rememberInfiniteTransition()
        val engineState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 500,
                    easing = LinearEasing
                )
            )
        )

        val positionState = infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            )
        )

        resource = if(engineState.value <= 0.5f){
            painterResource(id = R.drawable.rocket1)
        }else{
            painterResource(id = R.drawable.rocket2)
        }

        modifier = Modifier.offset(
            x= (maxWidth - rocketSize) * positionState.value,
            y= (maxHeight - rocketSize) - ((maxHeight - rocketSize) * positionState.value),
        )
    }


    Image(
        painter = resource,
        modifier = modifier
            .width(rocketSize)
            .height(rocketSize),
        contentDescription = "ROCKET"
    )
}
@Composable
fun LaunchButton(
    animateState:Boolean,
    onToggleAnimationState:()->Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center)
    {
            if(animateState){
                Button(
                    onClick = onToggleAnimationState,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red,
                        contentColor = Color.White)
                ) {
                    Text("STOP")
                }
            }else{
                Button(
                    onClick = onToggleAnimationState,
                ) {
                    Text("LAUNCH")
                }
            }
    }
}