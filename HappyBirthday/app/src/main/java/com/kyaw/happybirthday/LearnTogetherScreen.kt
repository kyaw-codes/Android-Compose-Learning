package com.kyaw.happybirthday

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyaw.happybirthday.ui.theme.HappyBirthdayTheme

@Composable
fun LearnTogetherScreen() {
    HappyBirthdayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                ImageHeader()
                TextContent(modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
private fun ImageHeader() {
    Image(painter = painterResource(
        id = R.drawable.bg_compose_background),
        contentDescription = null
    )
}

@Composable
private fun TextContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.jet_pack_compose_tutorial),
            fontSize = 24.sp,
        )

        Text(
            text = stringResource(id = R.string.jet_pack_compose_tutorial_desc1),
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = stringResource(id = R.string.jet_pack_compose_tutorial_desc2),
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview
@Composable
private fun LearnTogetherScreenPreview() {
    LearnTogetherScreen()
}