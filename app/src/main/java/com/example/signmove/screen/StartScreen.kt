package com.example.signmove.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.bold
import com.example.signmove.component.Button

@Composable
fun StartScreen(navController: NavHostController = rememberNavController()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) { Text(
            text = "서명으로 시작하는\n작은 발걸음",
            color = colorResource(id = R.color.gray5),
            textAlign = TextAlign.Center,
            fontFamily = bold,
            fontSize = 28.sp,
            lineHeight = 39.2.sp,
            modifier = Modifier.align(Alignment.Center)
        )
        Button(
            text = "시작하기",
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}


@Preview (showBackground = true)
@Composable
fun StartPreview() {
    StartScreen()
}