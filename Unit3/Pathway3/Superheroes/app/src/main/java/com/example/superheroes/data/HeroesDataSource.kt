package com.example.superheroes.data

import com.example.superheroes.R
import com.example.superheroes.model.Hero

object HeroesRepository {
    val heroes = listOf(
        Hero(
            nameResId = R.string.hero_name_1,
            descResId = R.string.hero_desc_2,
            imgResId = R.drawable.android_superhero1
        ),
        Hero(
            nameResId = R.string.hero_name_2,
            descResId = R.string.hero_desc_2,
            imgResId = R.drawable.android_superhero2
        ),
        Hero(
            nameResId = R.string.hero_name_3,
            descResId = R.string.hero_desc_3,
            imgResId = R.drawable.android_superhero3
        ),
        Hero(
            nameResId = R.string.hero_name_4,
            descResId = R.string.hero_desc_4,
            imgResId = R.drawable.android_superhero4
        ),
        Hero(
            nameResId = R.string.hero_name_5,
            descResId = R.string.hero_desc_5,
            imgResId = R.drawable.android_superhero5
        ),
        Hero(
            nameResId = R.string.hero_name_6,
            descResId = R.string.hero_desc_6,
            imgResId = R.drawable.android_superhero6
        )
    )
}