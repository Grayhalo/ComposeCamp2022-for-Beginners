package com.example.thirtydaysfruit.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Fruit(val dayNum: Int, @StringRes val nameResId: Int, @StringRes val descResId: Int, @DrawableRes val imgResId: Int)