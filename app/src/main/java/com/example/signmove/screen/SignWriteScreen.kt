package com.example.signmove.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.component.BackOrCompleteBar
import com.example.signmove.component.InputField
import com.example.signmove.component.NavigationBar
import com.example.signmove.medium

@Composable
fun SignWriteScreen(navController: NavHostController = rememberNavController()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white))
                .imePadding()
        ) {
            item { BackOrCompleteBar(pagename = "게시물 작성") }
            item { PhotoAddButton() }
            item { InputField(descriptext = "제목", inputtext = "입력해 주세요") }
            item { InputField(descriptext = "목표 인원", inputtext = "입력해 주세요") }
            item { InputField(descriptext = "내용", inputtext = "화곡동에서 진행할 서명운동 내용을 적어주세요.\n기본적인 예의는 지켜주시기 바랍니다") }
            item { ExposeCheckBox() }

        }
    }
}

@Composable
fun PhotoAddButton() {
    val photocount = 0
    val maxphotocount = 10
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .padding(vertical = 16.dp, horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .width(52.dp)
                .height(52.dp)
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.gray2),
                    shape = RoundedCornerShape(8.dp)
                )
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 6.dp)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(8.dp),
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.photo),
                contentDescription = "사진"
            )
            Text(
                text = "${photocount}/${maxphotocount}",
                color = colorResource(id = R.color.gray3),
                fontFamily = medium,
                fontSize = 12.sp,
                lineHeight = 16.8.sp
            )
        }
    }
}


@Composable
fun ExposeCheckBox() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(vertical = 10.dp, horizontal = 20.dp)

    ) {
        Image(
            painter = painterResource(
                id = if (isChecked) R.drawable.checked else R.drawable.uncheck
            ),
            contentDescription = "체크박스",
            modifier = Modifier
                .clickable {
                    isChecked = !isChecked
                }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "게시물을 전체 지역에 노출",
            color = colorResource(id = R.color.primary),
            fontFamily = medium,
            fontSize = 14.sp,
            lineHeight = 19.6.sp
        )
    }
}


@Preview (showBackground = true)
@Composable
fun SignWritePreview() {
    SignWriteScreen()
}