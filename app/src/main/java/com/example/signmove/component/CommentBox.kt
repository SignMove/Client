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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.bold
import com.example.signmove.regular

@Composable
fun CommentBox() {
    val name = "나제준"
    val comment = "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ"
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 20.dp)
    ) {
        Row {
            Box(modifier = Modifier
                .size(20.dp)
                .background(
                    color = colorResource(id = R.color.gray1),
                    shape = RoundedCornerShape(10.dp)
                )
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = name,
                color = colorResource(id = R.color.gray5),
                fontFamily = bold,
                fontSize = 14.sp,
                lineHeight = 19.6.sp
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Row {
            Spacer(modifier = Modifier.width(30.dp))
            Text(
                text = comment,
                color = colorResource(id = R.color.gray4),
                fontFamily = regular,
                fontSize = 12.sp,
                lineHeight = 16.8.sp
            )
        }
    }
}