package com.example.signmove.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.bold

@Composable
fun TopBar(
    onRegionSelectClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(vertical = 16.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onRegionSelectClick),
        ) {
            Text(
                text = "은평구",
                fontFamily = bold,
                fontSize = 20.sp,
                lineHeight = 28.sp,
                color = colorResource(id = R.color.gray5)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
                painter = painterResource(id = R.drawable.down),
                contentDescription = "동네 선택"
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // 검색 아이콘 부분
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = "검색",
            modifier = Modifier
                .clickable(onClick = onSearchClick)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TopbarPreview() {
    TopBar(
        onRegionSelectClick = { /* 빈 람다 */ },
        onSearchClick = { /* 빈 람다 */ }
    )
}
