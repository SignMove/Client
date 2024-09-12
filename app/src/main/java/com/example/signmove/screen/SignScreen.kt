package com.example.signmove.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.component.IssueBox
import com.example.signmove.component.NavigationBar
import com.example.signmove.component.SignBox
import com.example.signmove.component.TopBar

@Composable
fun SignScreen(navController: NavHostController = rememberNavController()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                TopBar(
                    onRegionSelectClick = {
                        navController.navigate("region select")
                    },
                    onSearchClick = {
                        navController.navigate("search")
                    }
                )
            }
            repeat(10) { item { SignBox {
                navController.navigate("sign detail")
            } } }
        }

        SignPlus(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 84.dp, end = 24.dp),
            onClick = {
                navController.navigate("sign write")
            }
        )

        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            navController = navController
        )
    }
}


@Composable
fun SignPlus(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .width(56.dp)
            .height(56.dp)
            .background(
                color = colorResource(id = R.color.primary),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.add),
            contentDescription = "그룹 추가",
            tint = colorResource(id = R.color.white)
        )
    }
}

@Preview (showBackground = true)
@Composable
fun SignScreenPreview() {
    SignScreen()
}