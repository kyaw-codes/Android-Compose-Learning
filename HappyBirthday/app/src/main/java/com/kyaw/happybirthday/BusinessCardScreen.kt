package com.kyaw.happybirthday

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyaw.happybirthday.ui.theme.HappyBirthdayTheme

@Composable
fun BusinessCardScreen() {
    HappyBirthdayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.DarkGray
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                LogoAndHeader()

                NameSection()
            }
        }
    }
}

@Composable
private fun LogoAndHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Yellow),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
        Column(
            verticalArrangement = Arrangement.spacedBy((-12).dp),
            modifier = Modifier.background(Color.DarkGray)
        ) {
            Text(
                text = "Divergent".uppercase(),
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 32.sp,
                    color = Color.White
                )
            )
            Text(
                text = "Studio".uppercase(),
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 32.sp,
                    color = Color.White
                )
            )
            Text(
                modifier = Modifier.padding(top = 6.dp),
                text = "be with you always",
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp,
                    color = Color.LightGray
                )
            )
        }
    }
}

@Composable
private fun NameSection() {
    Column(modifier = Modifier.background(Color.DarkGray), verticalArrangement = Arrangement.spacedBy(-(12).dp)) {
        Text(text = "Kyaw".uppercase(), style = TextStyle(color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Light))
        Text(text = "Monkey".uppercase(), style = TextStyle(color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Medium))
        Text(text = "Leading Mobile Developer", style = TextStyle(color = Color.White, fontSize = 18.sp), modifier = Modifier.padding(top = 12.dp))

        Column(
            modifier = Modifier.padding(top = 40.dp).padding(bottom = 80.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            ContactInfoRow(Icons.Outlined.Phone, "+669 151 1541")
            ContactInfoRow(Icons.Outlined.Email, "kyaw.codes@gmail.com")
            ContactInfoRow(Icons.Outlined.AccountBox, "@KyawTheMonkey")
        }
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, title: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(end = 8.dp).size(20.dp)
        )
        Text(
            text = title,
            style = TextStyle(color = Color.White, fontSize = 16.sp)
        )
    }
}

@Preview
@Composable
private fun BusinessCardScreenPreview() {
    BusinessCardScreen()
}