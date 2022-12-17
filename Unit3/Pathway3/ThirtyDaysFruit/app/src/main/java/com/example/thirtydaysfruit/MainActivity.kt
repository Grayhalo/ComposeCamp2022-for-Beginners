package com.example.thirtydaysfruit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysfruit.data.FruitDataSource.fruits
import com.example.thirtydaysfruit.model.Fruit
import com.example.thirtydaysfruit.ui.theme.ThirtyDaysFruitTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysFruitTheme {
                // A surface container using the 'background' color from the theme
                     ThirtyDaysFruitApp()
             }
        }
    }
}

@Composable
fun ThirtyDaysFruitApp() {
    //FruitItem(fruit = fruits[0])
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(fruits) {
                FruitItem(fruit = it)
            }
        }
    }
}

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FruitItem(fruit: Fruit, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp),
            //.height(300.dp),
        elevation = 4.dp,
        onClick = { expanded = !expanded }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 8.dp, end = 15.dp, bottom = 8.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            DayAndFruitName(dayNum = fruit.dayNum, nameResId = fruit.nameResId)
            FruitImage(imgResId = fruit.imgResId, nameResId = fruit.nameResId)
            if (expanded) {
                FruitDesc(descResId = fruit.descResId)
            }
        }
    }
}

@Composable
fun DayAndFruitName(dayNum: Int, @StringRes nameResId: Int) {
    Column() {
        Text(
            text = stringResource(id = R.string.day, dayNum),
            style = MaterialTheme.typography.h2
        )
        Text(
            text = stringResource(id = nameResId),
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun FruitImage(@DrawableRes imgResId: Int, @StringRes nameResId: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 4.dp),
        painter = painterResource(id = imgResId),
        contentDescription = stringResource(id = nameResId)
    )
}

@Composable
fun FruitDesc(@StringRes descResId: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = descResId),
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(top = 4.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ThirtyDaysFruitTheme(darkTheme = false) {
        ThirtyDaysFruitApp()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DarkThemePreview() {
    ThirtyDaysFruitTheme(darkTheme = true) {
        ThirtyDaysFruitApp()
    }
}