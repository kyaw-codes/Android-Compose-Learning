package com.kyaw.happybirthday

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kyaw.happybirthday.ui.theme.HappyBirthdayTheme

@Composable
fun ComposeQuadrant() {
    HappyBirthdayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                Column(modifier = Modifier.weight(1F)) {
                    Quadrant(
                        modifier = Modifier.weight(1F),
                        title = "Text composable",
                        subtitle = "Displays text and follows the recommended Material Design guidelines.",
                        backgroundColor = R.color.color_one
                    )

                    Quadrant(
                        modifier = Modifier.weight(1F),
                        title = "Row composable",
                        subtitle = "A layout composable that places its children in a horizontal sequence.",
                        backgroundColor = R.color.color_three
                    )
                }

                Column(modifier = Modifier.weight(1F)) {
                    Quadrant(
                        modifier = Modifier.weight(1F),
                        title = "Image composable",
                        subtitle = "Creates a composable that lays out and draws a given Painter class object.",
                        backgroundColor = R.color.color_two
                    )

                    Quadrant(
                        modifier = Modifier.weight(1F),
                        title = "Column composable",
                        subtitle = "A layout composable that places its children in a vertical sequence.",
                        backgroundColor = R.color.color_four
                    )
                }

            }
        }
    }
}

@Composable
fun Quadrant(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    @ColorRes backgroundColor: Int
) {
    Column(
        modifier = modifier
            .background(colorResource(id = backgroundColor))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = subtitle, style = TextStyle(textAlign = TextAlign.Justify))
    }
}

@Preview
@Composable
private fun ComposeQuadrantPreview() {
    ComposeQuadrant()
}