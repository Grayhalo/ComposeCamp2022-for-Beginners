package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceMain()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceMain() {
    var index by remember { mutableStateOf(1) }
    val imageResource : Int
    val titleResource : Int
    val artistResource : Int
    val yearResource : Int?

    when(index) {
        1 -> {
            imageResource = R.drawable.man_sight
            titleResource = R.string.man_sight_title
            artistResource = R.string.man_sight_artist
            yearResource = R.string.man_sight_year
        }
        2 -> {
            imageResource = R.drawable.wrold_sight_day
            titleResource = R.string.baby_in_glass_title
            artistResource = R.string.baby_in_glass_artist
            yearResource = R.string.baby_in_glass_year
        }
        3 -> {
            imageResource = R.drawable.iceland
            titleResource = R.string.iceland_title
            artistResource = R.string.iceland_artist
            yearResource = null
        }
        4 -> {
            imageResource = R.drawable.venice_beach
            titleResource = R.string.venice_beach_title
            artistResource = R.string.venice_beach_artist
            yearResource = null
        }
        else -> {
            imageResource = R.drawable.al_salmi_desert
            titleResource = R.string.al_salmi_title
            artistResource = R.string.al_salmi_artist
            yearResource = R.string.al_salmi_year
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 10.dp)
    ) {
        ArtImage(resId = imageResource, descId = titleResource)
        Spacer(modifier = Modifier.height(16.dp))
        ArtInfo(titleID = titleResource, artistId = artistResource, yearId = yearResource)
        Spacer(modifier = Modifier.height(10.dp))
        Buttons(
            prevOnClick = { if(index > 1) index-- else index = 5 },
            nextOnClick = { if(index < 5) index++ else index = 1 }
        )
    }
}

@Composable
fun ArtImage(resId: Int, descId: Int) {
    Column(modifier = Modifier.fillMaxHeight(fraction = 0.7f).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            elevation = 10.dp
        ) {
            Image(
                painter = painterResource(id = resId),
                contentDescription = stringResource(id = descId),
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = Color(red = 150, green = 150, blue = 150),
                        shape = RectangleShape
                    )
                    .padding(all = 20.dp)

            )
        }
    }
}

@Composable
fun ArtInfo(titleID: Int, artistId: Int, yearId: Int? = null) {
    val year = if (yearId == null) "" else " (" + stringResource(id = yearId) + ")"
//    Box(modifier = Modifier
//        .wrapContentSize()
//        .border(width = 2.dp, color = Color.Green)
//        .padding(all = 10.dp)
//    ) {
        val titleFont = FontFamily(Font(R.font.assistant_light))
    Surface(
        elevation = 5.dp,
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(all = 15.dp)
        ) {
            Text(
                text = stringResource(id = titleID),
                fontSize = 25.sp,
                fontFamily = titleFont
            )
            Row () {
                Text(
                    text = stringResource(id = artistId),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                if (yearId != null) {
                    Text(
                        text = year,
                        fontSize = 14.sp
                    )
                }
            }

        }
    }

}

@Composable
fun Buttons(prevOnClick: () -> Unit, nextOnClick: () -> Unit) {
    Row(
        modifier = Modifier.padding(start = 15.dp, end = 15.dp).fillMaxWidth()
    ) {
        Button(
            onClick = prevOnClick,
            modifier = Modifier.width(150.dp)   //.weight(5f)
        ) {
            Text(stringResource(id = R.string.previous_button_text))
        }
        Spacer(modifier = Modifier.weight(1f))    // Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = nextOnClick,
            modifier = Modifier.width(150.dp)       //.weight(5f)
        ) {
            Text(stringResource(id = R.string.next_button_text))
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceMain()
    }
}