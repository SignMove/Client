package com.example.signmove.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.bold


@Composable
fun RegisterMainText(text : String, onClick: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(vertical = 36.dp, horizontal = 20.dp)
            .background(color = colorResource(id = R.color.white))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = "뒤로가기",
            modifier = Modifier.clickable(onClick = onClick)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = text,
            color = colorResource(id = R.color.gray5),
            fontFamily = bold,
            fontSize = 24.sp,
            lineHeight = 33.6.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainTextPreview() {
    RegisterMainText("이름을 입력해주세요", onClick = {})
}