package com.example.signmove.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.network.HttpException
import com.example.signmove.R
import com.example.signmove.api.Client
import com.example.signmove.component.IssueBox
import com.example.signmove.component.NavigationBar
import com.example.signmove.component.SignBox
import com.example.signmove.component.TopBar
import com.example.signmove.model.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun IssueScreen(navController: NavHostController = rememberNavController()) {
    val newses = remember { mutableStateListOf<News>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                TopBar(
                    onRegionSelectClick = { navController.navigate("region select") },
                    onSearchClick = { navController.navigate("search") }
                )
            }
            items(newses) { news ->  // `newses`의 크기에 따라 동적으로 렌더링
                IssueBox(
                    title = news.title,
                    image = news.image
                ) {
                    navController.navigate("issue-detail/${news.id}")
                }
            }
        }
        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            navController = navController
        )
    }

    LaunchedEffect(Unit) {
        try {
            val res = Client.newsService.listNews(50)
            if (res.isSuccessful) {
                val news = res.body()
                if (news != null) {
                    newses.addAll(news)
                }
            }
        } catch (e: Exception) {
            Log.d("test", "Exception: ${e.message}")
        }
    }
}
