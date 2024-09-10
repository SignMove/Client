package com.example.signmove.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.component.IssueBox
import com.example.signmove.component.NavigationBar
import com.example.signmove.component.TopBar

@Composable
fun IssueScreen(navController: NavHostController = rememberNavController()) {
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
            item { TopBar() }
            item { IssueBox() }
            item { IssueBox() }
            item { IssueBox() }
            item { IssueBox() }
            item { IssueBox() }
            item { IssueBox() }
            item { IssueBox() }
            item { IssueBox() }
            item { IssueBox() }
        }
        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            navController = navController
        )
    }
}

@Preview (showBackground = true)
@Composable
fun IssuePreview() {
    IssueScreen()
}