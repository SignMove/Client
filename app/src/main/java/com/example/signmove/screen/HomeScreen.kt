package com.example.signmove.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.signmove.bold
import com.example.signmove.component.IssueBox
import com.example.signmove.component.NavigationBar
import com.example.signmove.component.SignBox
import com.example.signmove.component.TopBar
import com.example.signmove.regular

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white))
        ) {
            item {
                TopBar(
                    onRegionSelectClick = { navController.navigate("region select") },
                    onSearchClick = { navController.navigate("search") }
                )
            }
            item { MainImage() }
            item {
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.gray1))
                )
            }
            item { SubTitle() }
            repeat(3) { item { SignBox {
                navController.navigate("sign detail")
            } } }
            item { SeeMoreButton() }
//            repeat(3) { item { IssueBox {
//                navController.navigate("sign detail")
//            } } }
            item { SeeMoreButton() }
        }

        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            navController = navController
        )
    }
}

@Composable
fun MainImage() {
    val min = 3
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.testimage),
            contentDescription = "이론 머스크"
        )
        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.white).copy(alpha = 0.8f))
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(79.dp)
                    .padding(start = 20.dp, bottom = 20.dp, end = 20.dp, top = 10.dp)
            ) {
                Text(
                    text = "일론머스크, 도약하다!",
                    color = colorResource(id = R.color.gray5),
                    fontFamily = bold,
                    fontSize = 20.sp,
                    lineHeight = 28.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(17.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "조선일보",
                        fontSize = 12.sp,
                        fontFamily = regular,
                        lineHeight = 16.8.sp,
                        color = colorResource(id = R.color.gray4)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(modifier = Modifier
                        .size(4.dp)
                        .background(
                            color = colorResource(id = R.color.gray1),
                            shape = RoundedCornerShape(2.dp)
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${min}분 전",
                        fontSize = 12.sp,
                        fontFamily = regular,
                        lineHeight = 16.8.sp,
                        color = colorResource(id = R.color.primary)
                    )
                }
            }
        }
    }
}

@Composable
fun SubTitle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(41.dp)
            .padding(vertical = 8.dp, horizontal = 20.dp)
    ) {
        Text(
            text = "목표 달성까지 한걸음!",
            color = colorResource(id = R.color.gray5),
            fontFamily = bold,
            fontSize = 18.sp,
            lineHeight = 25.2.sp
        )
    }
}

@Composable
fun SeeMoreButton() {
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "더 보기",
                color = colorResource(id = R.color.gray4),
                fontFamily = bold,
                fontSize = 14.sp,
                lineHeight = 19.6.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "더보기"
            )

        }
//        Spacer(modifier = Modifier
//            .height(8.dp)
//            .fillMaxWidth()
//            .background(color = colorResource(id = R.color.gray1)))
    }

}






@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}