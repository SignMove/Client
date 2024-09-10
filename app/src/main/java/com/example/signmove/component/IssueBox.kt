package com.example.signmove.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.bold
import com.example.signmove.regular
import com.example.signmove.screen.IssueScreen

@Composable
fun IssueBox() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(104.dp)
            .background(color = colorResource(id = R.color.white))
            .padding(vertical = 12.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageBox()
        Spacer(modifier = Modifier.width(14.dp))
        IssueBoxInfoCol()
    }
}

@Composable
fun IssueBoxInfoCol() {
    val title = "제목"
    val writer = "언론사"
    val min = 5
    Column (
        modifier = Modifier
            .width(259.dp)
            .height(51.dp)
    ) {
        Text(
            text = title,
            fontFamily = bold,
            fontSize = 16.sp,
            lineHeight = 22.4.sp,
            color = colorResource(id = R.color.gray5)
        )
        Spacer(modifier = Modifier.height(14.dp))
        Row (
            modifier = Modifier
                .width(107.dp)
                .height(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = writer,
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
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIssueBox() {
    IssueBox()
}