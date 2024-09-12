package com.example.signmove.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.bold
import com.example.signmove.medium

@Composable
fun BackOrCompleteBar(pagename : String, onclick: () -> Unit) {
    Column {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "이전",
                color = colorResource(id = R.color.gray4),
                fontSize = 18.sp,
                fontFamily = medium,
                lineHeight = 25.2.sp,
                modifier = Modifier
                    .clickable(onClick = onclick)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = pagename,
                color = colorResource(id = R.color.gray5),
                textAlign = TextAlign.Center,
                fontFamily = bold,
                fontSize = 18.sp,
                lineHeight = 25.2.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "완료",
                color = colorResource(id = R.color.primary),
                fontSize = 18.sp,
                fontFamily = medium,
                lineHeight = 25.2.sp,
                modifier = Modifier
                    .clickable(onClick = onclick)

            )
        }
    }
    Spacer(modifier = Modifier
        .height(1.dp)
        .fillMaxWidth()
        .background(color = colorResource(id = R.color.gray1)))

}


@Preview (showBackground = true)
@Composable
fun BarPreview() {
    BackOrCompleteBar("게시물 작성", onclick = {})
}