package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompleted.ui.theme.TaskCompletedTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskCompletedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    TaskCompletedView(mainMessage = stringResource(id = R.string.completed_message), subMessage = stringResource(id = R.string.completed_sub_message))
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
fun TaskCompletedView(mainMessage: String, subMessage: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CompletedIconImage()
        CompletedMessage(message = mainMessage)
        CompletedSubMessage(message = subMessage)
    }
}

@Composable
fun CompletedIconImage() {
    val completedImage = painterResource(id = R.drawable.ic_task_completed)

    Image(
        painter = completedImage,
        contentDescription = null,
        modifier = Modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(start = 30.dp, end = 30.dp)
    )
}

@Composable
fun CompletedMessage(message: String) {
    Text(
        text = message,
        fontSize = 24.sp,
        modifier = Modifier
            //.fillMaxWidth()
            .padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun CompletedSubMessage(message: String) {
    Text(
        text = message,
        fontSize = 16.sp,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityPreview() {
    TaskCompletedTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            //CompletedIconImage()
            //CompletedMessage(message = stringResource(id = R.string.completed_message))
            //CompletedSubMessage(message = stringResource(id = R.string.completed_sub_message))
            TaskCompletedView(mainMessage = stringResource(id = R.string.completed_message), subMessage = stringResource(id = R.string.completed_sub_message))
        }
    }
}