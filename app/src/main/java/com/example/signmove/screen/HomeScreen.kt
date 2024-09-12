package com.example.signmove.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.signmove.component.BetweenLayer
import com.example.signmove.component.Layer
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

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
            item { SubTitle("목표 달성까지 한걸음!") }
            repeat(3) { item { SignBox {
                navController.navigate("sign detail")
            } } }
            item { SeeMoreButton{
                navController.navigate("sign")
            } }
            item { BetweenLayer() }
            item { SubTitle(text = "오늘의 HOT 이슈!") }
            repeat(3) { item { IssueBox {
                navController.navigate("sign detail")
            } } }
            item { SeeMoreButton{
                navController.navigate("issue")
            } }
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
    val images = listOf(R.drawable.testimage, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5)
    val titles = listOf(
        "이론 머스크 도약하다",
        "도황 빡치다",
        "도황 쓰디 쓴 고배를 마시다",
        "도황 성장하다",
        "도황 체포되다"
    )
    val pagerState = rememberPagerState()
    val currentPage = pagerState.currentPage

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        HorizontalPager(
            count = images.size,
            state = pagerState
        ) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = "Image $page",
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .background(color = colorResource(id = R.color.white).copy(alpha = 0.8f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, bottom = 8.dp, end = 20.dp, top = 10.dp)
            ) {
                Text(
                    text = titles[currentPage],
                    color = colorResource(id = R.color.gray5),
                    fontFamily = bold,
                    fontSize = 20.sp,
                    lineHeight = 28.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
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
                    Box(
                        modifier = Modifier
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
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    FloatingBar(currentPage = currentPage, totalPages = images.size)
                }
            }
        }
    }
}

@Composable
fun FloatingBar(currentPage: Int, totalPages: Int) {
    Row {
        repeat(totalPages) { index ->
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .background(
                        color = if (index == currentPage) colorResource(id = R.color.primary) else colorResource(
                            id = R.color.gray1
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}




@Composable
fun SubTitle(text : String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(41.dp)
            .padding(vertical = 8.dp, horizontal = 20.dp)
    ) {
        Text(
            text = text,
            color = colorResource(id = R.color.gray5),
            fontFamily = bold,
            fontSize = 18.sp,
            lineHeight = 25.2.sp
        )
    }
}

@Composable
fun SeeMoreButton(onClick: () -> Unit) {
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .padding(vertical = 12.dp)
                .clickable(onClick = onClick)
            ,
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
    }
}






@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}