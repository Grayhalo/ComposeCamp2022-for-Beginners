package com.example.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.ui.theme.TipTimeTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipTimeScreen()
                }
            }
        }
    }
}

@Composable
fun TipTimeScreen() {
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercent, roundUp)
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            //modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        //EditNumberField()
        TextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text(stringResource(id = R.string.bill_amount))},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next)
        )
        TextField(
            value = tipInput,
            onValueChange = { tipInput = it },
            label = { Text(stringResource(id = R.string.how_was_the_service))},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(R.string.round_up_tip))
            Switch(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
                checked = roundUp,
                onCheckedChange = { roundUp = it },
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.DarkGray
                )
            )
        }
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.tip_amount, tip),
            //modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

//@Composable
//fun EditNumberField() {
//
//
//}

@VisibleForTesting
internal fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0,
    roundUp: Boolean
): String {
    var tip = tipPercent / 100 * amount
    if(roundUp) tip = kotlin.math.ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TipTimeTheme {
        TipTimeScreen()
    }
}