package com.example.signmove.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.component.Button
import com.example.signmove.component.InputField
import com.example.signmove.component.RegisterMainText
import com.example.signmove.component.TownButton
import com.example.signmove.component.TownInfoBox
import com.example.signmove.medium

@Composable
fun SelectTownScreen(name: String?, description: String?, navController: NavHostController = rememberNavController()) {
    var town by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        RegisterMainText(text = "동네를 선택해주세요") {
            navController.navigate("intro")
        }
        InputField(descriptext = "동네", inputtext = "동명(읍, 면)으로 검색",
                value = town,
            onValueChange = { new -> town = new }
        )
        TownButton()
        TownInfoBox(towninfotext = "호로봄ㄴ")
        Spacer(modifier = Modifier.weight(1f))
        Button(text = "다음") {
            if (town.isNotEmpty())
                navController.navigate("check/$name/$description/$town")
        }
    }
}
