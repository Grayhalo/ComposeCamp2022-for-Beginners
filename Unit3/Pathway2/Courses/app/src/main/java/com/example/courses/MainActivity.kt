package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courses.data.DataSource
import com.example.courses.model.Course
import com.example.courses.ui.theme.CoursesTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CoursesTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    CoursesApp()
//                }
//            }
            CoursesApp()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CoursesApp() {
    CoursesTheme() {
        Scaffold(
            content = {
                //CourseCard(course = Course(imgResId = R.drawable.architecture, nameResId = R.string.course1_name, stepNumResId = R.string.course1_step))
                CourseCardList(courses = DataSource.topics)
            }
        )
    }
    //CourseCard(course = Course(imgResId = R.drawable.architecture, nameResId = R.string.course1_name, stepNumResId = R.string.course1_step))
}

@ExperimentalFoundationApi
@Composable
fun CourseCardList(courses: List<Course>) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 140.dp),
        modifier = Modifier.padding(end = 8.dp)
        //cells = GridCells.Fixed(2)
    ) {
        items(courses.size) {
            index -> CourseCard(course = courses[index])
        }
    }

}

@Composable
fun CourseCard(course: Course) {
    Card(modifier = Modifier.padding(start = 8.dp, top = 8.dp), elevation = 4.dp) {
        Row {
            Image(
                painter = painterResource(id = course.imgResId),
                contentDescription = stringResource(id = course.nameResId),
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = stringResource(id = course.nameResId),
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    //style = MaterialTheme.typography.h6,
                    fontSize = 14.sp,
                    //fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp, start = 16.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
                    )
                    Text(
                        text = stringResource(id = course.stepNumResId),
                        modifier = Modifier.padding(start = 8.dp),
                        //style = MaterialTheme.typography.h6,
                        fontSize = 13.sp,
                        //fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
@ExperimentalFoundationApi
fun CoursesAppPreview() {
    CoursesTheme {
        CoursesApp()
    }
}