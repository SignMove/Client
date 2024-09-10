package com.example.signmove.component

import android.icu.text.IDNA.Info
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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

@Composable
fun SignBox() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(112.dp)
            .background(color = colorResource(id = R.color.white))
            .padding(vertical = 16.dp, horizontal = 20.dp)
    ) {
        SignBoxInfoColumn()
        Spacer(modifier = Modifier.width(14.dp))
        ImageBox()
    }
}

@Composable
fun SignBoxInfoColumn() {
    val name = "제목"
    val writer = "작성자"
    val min = 5
    Column (
        modifier = Modifier
            .width(259.dp)
            .height(79.dp),
    ) {
        Text(
            text = name,
            fontFamily = bold,
            fontSize = 16.sp,
            lineHeight = 22.4.sp,
            color = colorResource(id = R.color.gray5)
        )
        Spacer(modifier = Modifier.height(14.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                .size(16.dp)
                .background(
                    color = colorResource(id = R.color.gray1),
                    shape = RoundedCornerShape(8.dp)
                )
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = writer,
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
        Spacer(modifier = Modifier.height(14.dp))
        Box(
            modifier = Modifier
                .width(259.dp)
                .height(12.dp)
                .background(
                    color = colorResource(id = R.color.gray1),
                    shape = RoundedCornerShape(6.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp)
                    .background(
                        color = colorResource(id = R.color.primary),
                        shape = RoundedCornerShape(6.dp)
                    )
            )
        }
    }
}

@Composable
fun ImageBox() {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(
                color = colorResource(id = R.color.gray1),
                shape = RoundedCornerShape(8.dp)
            )
    )
}


@Preview (showBackground = true)
@Composable
fun SignBoxPreview() {
    SignBox()
}