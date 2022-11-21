package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    ComposeArticleView(
                        title = stringResource(id = R.string.article_title),
                        prefaceContent = stringResource(id = R.string.preface_content),
                        bodyContent = stringResource(id = R.string.body_content)
                    )
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

@Composable
fun ComposeArticleView (title: String, prefaceContent: String, bodyContent: String) {
    Column {
        UpperBackgroundImage()
        ArticleTitle(title = title)
        PrefaceContent(content = prefaceContent)
        BodyContent(content = bodyContent)
    }
}

@Composable
fun UpperBackgroundImage() {
    val upperImage = painterResource(id = R.drawable.bg_compose_background)

    Image(
       painter = upperImage,
       contentDescription = null
    )
}

@Composable
fun ArticleTitle(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = Modifier
            //.fillMaxWidth()
            .wrapContentWidth(align = Alignment.Start)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
    )
}

@Composable
fun PrefaceContent(content: String) {
    Text(
        text = content,        
        modifier = Modifier
            //.fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
}

@Composable
fun BodyContent(content: String) {
    Text(
        text = content,
        modifier = Modifier
            //.fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityPreview() {
    ComposeArticleTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            //UpperBackgroundImage()
            //ArticleTitle(title = stringResource(id = R.string.article_title))
            //PrefaceContent(content = stringResource(id = R.string.preface_content))
            //BodyContent(content = stringResource(id = R.string.body_content))
            ComposeArticleView(
                title = stringResource(id = R.string.article_title),
                prefaceContent = stringResource(id = R.string.preface_content),
                bodyContent = stringResource(id = R.string.body_content)
            )
        }
    }
}