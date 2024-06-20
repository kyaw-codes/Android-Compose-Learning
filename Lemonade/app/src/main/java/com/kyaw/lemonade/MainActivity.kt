package com.kyaw.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyaw.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    var currentStep by remember {
        mutableStateOf(1)
    }

    var totalSqueezeCount by remember {
        mutableStateOf((1..6).random())
    }

    var currentSqueezeCount by remember {
        mutableStateOf(0)
    }

    val imageResource = when (currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val contentDescription = when (currentStep) {
        1 -> R.string.tap_the_lemon_tree
        2 -> R.string.keep_tapping_the_lemon
        3 -> R.string.tap_lemonade_to_drink
        else -> R.string.tap_empty_glass_to_start_again
    }

    val imageDescription = when (currentStep) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.glass_of_lemonade
        else -> R.string.empty_glass
    }

    val onClick = {
        currentStep = when (currentStep) {
            1 -> 2
            2 -> {
                if (currentSqueezeCount < totalSqueezeCount) {
                    currentSqueezeCount += 1
                    2
                } else {
                    currentSqueezeCount = 0
                    totalSqueezeCount = (1..6).random()
                    3
                }
            }

            3 -> 4
            else -> 1
        }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        TextButton(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.background),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(12.dp),
            onClick = onClick
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = imageDescription)
            )
        }
        Text(
            text = stringResource(id = contentDescription),
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview
@Composable
private fun LemonadePreview() {
    Lemonade()
}