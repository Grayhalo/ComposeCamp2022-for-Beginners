package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.SuperheroesTheme
import com.example.superheroes.data.HeroesRepository


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                SuperheroesApp()
            }
        }
    }
}

@Composable
fun SuperheroesApp() {
    Scaffold(
        topBar = {
            SuperheroesAppBar()
        }
    ) {
        //HeroItem(hero = HeroesRepository.heroes[0])
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(HeroesRepository.heroes) {
                HeroItem(hero = it)
            }
        }
    }
}

@Composable
fun SuperheroesAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .height(105.dp),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            HeroInformation(heroNameResId = hero.nameResId, heroDescResId = hero.descResId)
            Spacer(modifier = Modifier.weight(1f))
            HeroIcon(heroImageResId = hero.imgResId)
        }
    }
}

@Composable
fun HeroInformation(@StringRes heroNameResId: Int, @StringRes heroDescResId: Int, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .padding(end = 16.dp)
            .fillMaxWidth(0.72f)
    ) {
        Text(
            text = stringResource(id = heroNameResId),            
            style = MaterialTheme.typography.h2
        )
        Text(
            text = stringResource(id = heroDescResId),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun HeroIcon(@DrawableRes heroImageResId: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(73.dp)
            //.padding(8.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = heroImageResId),
        contentDescription = null,        
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SuperHeroesPreview() {
    SuperheroesTheme(darkTheme = false) {
        SuperheroesApp()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SuperHeroesDarkPreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroesApp()
    }
}