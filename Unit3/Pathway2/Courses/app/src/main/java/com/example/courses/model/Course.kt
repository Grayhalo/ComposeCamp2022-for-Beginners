package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(@DrawableRes val imgResId: Int, @StringRes val nameResId: Int, @StringRes val stepNumResId: Int)
