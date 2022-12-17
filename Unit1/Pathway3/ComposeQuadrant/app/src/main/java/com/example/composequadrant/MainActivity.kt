package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    val compFuncList = arrayOf(
                        ComposableFunc(R.string.text_func, R.string.text_desc, Color.Green),
                        ComposableFunc(R.string.image_func, R.string.image_desc, Color.Yellow),
                        ComposableFunc(R.string.row_func, R.string.row_desc, Color.Cyan),
                        ComposableFunc(R.string.column_func, R.string.column_desc, Color.LightGray)
                    )

                    QuadrantView(compFuncList = compFuncList)
                }
            }
        }
    }
}

class ComposableFunc(val name: Int, val desc: Int, val color: Color)

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

@Composable
fun FuncName(name: String) {
    Text(
        text = name,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            //.fillMaxWidth()
            .padding(bottom = 16.dp)
    )
}

@Composable
fun FuncDesc(desc: String) {
    Text(
        text = desc,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun FuncSection(name: String, desc: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
        FuncName(name = name)
        FuncDesc(desc = desc)
    }
}

//@Composable
//fun QuadRow(name1: String, desc1: String, color1: Color, name2: String, desc2: String, color2: Color) {
//    Row{
//        Column(Modifier.weight(1f).background(color1)) {
//            FuncSection(name = name1, desc = desc1)
//        }
//        Column(Modifier.weight(1f).background(color2)) {
//            FuncSection(name = name2, desc = desc2)
//        }
//    }
//}

@Composable
fun QuadRow(composableFun1: ComposableFunc, composableFun2: ComposableFunc) {
    Row{
        Column(
            Modifier
                .weight(1f)
                .background(composableFun1.color)) {
            FuncSection(
                name = stringResource(id = composableFun1.name),
                desc = stringResource(id = composableFun1.desc)
            )
        }
        Column(
            Modifier
                .weight(1f)
                .background(composableFun2.color)) {
            FuncSection(
                name = stringResource(id = composableFun2.name),
                desc = stringResource(id = composableFun2.desc)
            )
        }
    }
}

@Composable
fun QuadrantView(compFuncList: Array<ComposableFunc>) {
    Column{
        Row(Modifier.weight(1f)) {
            QuadRow(compFuncList[0], compFuncList[1])
        }
        Row(Modifier.weight(1f)) {
            QuadRow(compFuncList[2], compFuncList[3])
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            //FuncSection(name = stringResource(id = R.string.text_func), desc = stringResource(id = R.string.text_desc))
//            QuadRow(
//                name1 = stringResource(id = R.string.text_func),
//                desc1 = stringResource(id = R.string.text_desc),
//                color1 = Color.Green,
//                name2 = stringResource(id = R.string.image_func),
//                desc2 = stringResource(id = R.string.image_desc),
//                color2 = Color.Yellow
//            )

            val compFuncList = arrayOf(
                ComposableFunc(R.string.text_func, R.string.text_desc, Color.Green),
                ComposableFunc(R.string.image_func, R.string.image_desc, Color.Yellow),
                ComposableFunc(R.string.row_func, R.string.row_desc, Color.Cyan),
                ComposableFunc(R.string.column_func, R.string.column_desc, Color.LightGray)
            )

            //QuadRow(compFuncList[0], compFuncList[1])
            QuadrantView(compFuncList = compFuncList)
        }
    }
}