package com.example.signmove.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.component.Button
import com.example.signmove.component.InputField
import com.example.signmove.component.RegisterMainText

@Composable
fun InputNameScreen(navController: NavHostController = rememberNavController()) {
    var name by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        RegisterMainText(text = "이름을 입력해주세요") {
            //인텐트 !!!!
        }
        InputField(
            descriptext = "이름",
            inputtext = "입력해 주세요",
            value = name,
            onValueChange = { newName -> name = newName }
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(text = "다음") {
            if (name.isNotEmpty()) {
                navController.navigate("intro/$name")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun InputPreview() {
    InputNameScreen()
}