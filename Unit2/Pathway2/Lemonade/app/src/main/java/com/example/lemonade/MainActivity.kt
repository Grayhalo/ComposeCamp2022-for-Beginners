package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    LemonadeTextAndImage(Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeTextAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var level by remember { mutableStateOf(1) }

//        val imageResource = when(level) {
//        1 -> R.drawable.lemon_tree
//        2 -> R.drawable.lemon_squeeze
//        3 -> R.drawable.lemon_drink
//        else -> R.drawable.lemon_restart
//    }

//    val tapLimit = when(level) {
//        2 -> (2..4).random()
//        else -> 1
//    }

    val imageResource : Int?
    val imageContentDesc : Int?
    val textResource : Int?
    val tapLimit : Int?

    when(level) {
        1 -> {
            imageResource = R.drawable.lemon_tree
            imageContentDesc = R.string.lemon_tree_desc
            textResource = R.string.lemon_tree_guide
            tapLimit = 1
        }
        2 -> {
            imageResource = R.drawable.lemon_squeeze
            imageContentDesc = R.string.lemon_squeeze_desc
            textResource = R.string.lemon_squeeze_guide
            tapLimit = (2..4).random()
        }
        3 -> {
            imageResource = R.drawable.lemon_drink
            imageContentDesc = R.string.lemon_drink_desc
            textResource = R.string.lemon_drink_guide
            tapLimit = 1
        }
        else -> {
            imageResource = R.drawable.lemon_restart
            imageContentDesc = R.string.lemon_restart_desc
            textResource = R.string.lemon_restart_guide
            tapLimit = 1
        }
    }

    var tapCount = 0

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = textResource),
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = imageContentDesc),
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color(red = 105, green = 205, blue = 216),
                    shape = RoundedCornerShape(5.dp)
                )
                .clickable {
                    tapCount++
                    if (tapCount >= tapLimit) {
                        level = if(level >= 4) 1 else level + 1
                    }
                }
        )

    }

}