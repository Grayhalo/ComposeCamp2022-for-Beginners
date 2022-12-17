package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(@StringRes val nameResId: Int, @StringRes val descResId: Int, @DrawableRes val imgResId: Int)
