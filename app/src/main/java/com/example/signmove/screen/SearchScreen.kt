package com.example.signmove.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.component.InputField

@Composable
fun SearchScreen(navController: NavHostController = rememberNavController()) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        item { SearchField(navController) }
    }
}

@Composable
fun SearchField(navController: NavHostController) {
    val town = "원흥동"

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrowback),
                contentDescription = "뒤로가기",
                tint = colorResource(id = R.color.gray4),
                modifier = Modifier.clickable {
                    navController.navigateUp()
                }
            )
            InputField(inputtext = "${town} 근처에서 검색")
        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.gray1))
        )
    }
}




@Preview (showBackground = true)
@Composable
fun SearchPreview() {
    SearchScreen()
}