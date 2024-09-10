package com.example.signmove.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.medium

@Composable
fun TownInfoBox(towninfotext : String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(vertical = 12.dp, horizontal = 24.dp)
    ) {
        Text(
            text = towninfotext,
            color = colorResource(id = R.color.gray5),
            fontFamily = medium,
            fontSize = 14.sp,
            lineHeight = 19.6.sp
        )
    }
}