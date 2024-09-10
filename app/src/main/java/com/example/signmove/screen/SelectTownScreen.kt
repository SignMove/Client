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
import com.example.signmove.component.TownInfoBox
import com.example.signmove.medium

@Composable
fun SelectTownScreen(navController: NavHostController = rememberNavController()) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        RegisterMainText(text = "동네를 선택해주세요")
        InputField(descriptext = "동네", inputtext = "동명(읍, 면)으로 검색")
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(vertical = 10.dp, horizontal = 20.dp)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(8.dp)
                )
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.gray4),
                    shape = RoundedCornerShape(8.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "위치"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "현재 위치로 찾기",
                color = colorResource(id = R.color.gray4),
                fontFamily = medium,
                fontSize = 14.sp,
                lineHeight = 19.6.sp
            )
        }
        TownInfoBox(towninfotext = "호로봄ㄴ")
        Spacer(modifier = Modifier.weight(1f))
        Button(text = "다음") {}
    }
}


@Preview(showBackground = true)
@Composable
fun SelectTownPreview() {
    SelectTownScreen()
}