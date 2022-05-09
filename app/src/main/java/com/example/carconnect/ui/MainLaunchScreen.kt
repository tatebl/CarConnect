package com.example.carconnect.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carconnect.R

@Composable
fun MainLaunchScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.corolla_ccexpress), contentDescription = "")
        
            Spacer(modifier = Modifier.height(50.dp))
        
            Text(text = "Connecting people with the car of their dreams",
                fontSize = 20.sp,
                style = TextStyle(fontFamily = FontFamily.Cursive))
        
            Spacer(modifier = Modifier.height(60.dp))
        
            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Existing User")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "New User")
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(text = "Continue without account",
                style = TextStyle(Color.Blue,textDecoration = TextDecoration.Underline))

    }
}


@Composable
@Preview
fun launchScreenPreview() {
    MainLaunchScreen()
}