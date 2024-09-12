package com.example.signmove.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.component.BackOrCompleteBar
import com.example.signmove.component.InputField
import com.example.signmove.component.TownButton
import com.example.signmove.component.TownInfoBox
import com.example.signmove.medium

@Composable
fun RegionSelectScreen(navController: NavHostController = rememberNavController()) {
    LazyColumn (
      modifier = Modifier
          .fillMaxSize()
          .background(color = colorResource(id = R.color.white))
    ) {
        item { BackOrCompleteBar(pagename = "내 지역 설정") {
            navController.navigateUp()
        } }
        item { Spacer(modifier = Modifier.height(6.dp)) }
        item { InputField(inputtext = "동명(읍, 면)으로 검색") }
        item { TownButton() }
        item { CurrentTown() }
        item { Spacer(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.gray1))) }
        item { TownInfoBox(towninfotext = "서울 용산구 청파동") }
        item { TownInfoBox(towninfotext = "서울 용산구 청파동") }
        item { TownInfoBox(towninfotext = "서울 용산구 청파동") }
        item { TownInfoBox(towninfotext = "서울 용산구 청파동") }
    }
}

@Composable
fun CurrentTown() {
    val town = "경기도 덕양구 원흥동"
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp, horizontal = 20.dp)
    ) {
        Text(
            text = "현재 설정된 지역 :",
            color = colorResource(id = R.color.gray5),
            fontFamily = medium,
            fontSize = 14.sp,
            lineHeight = 19.6.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = town,
            color = colorResource(id = R.color.primary),
            fontFamily = medium,
            fontSize = 14.sp,
            lineHeight = 19.6.sp
        )
    }
}


@Preview (showBackground = true)
@Composable
fun RegionPreview() {
    RegionSelectScreen()
}