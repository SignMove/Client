package com.example.signmove.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.signmove.R

@Composable
fun BetweenLayer() {
    Spacer(modifier = Modifier
        .height(8.dp)
        .fillMaxWidth()
        .background(color = colorResource(id = R.color.gray1)))
}