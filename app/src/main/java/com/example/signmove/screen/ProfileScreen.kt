package com.example.signmove.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.bold
import com.example.signmove.component.NavigationBar
import com.example.signmove.component.ProfileMenu
import com.example.signmove.regular
import com.example.signmove.semibold

@Composable
fun ProfileScreen(navController: NavHostController = rememberNavController()) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        ProfileBox()
        ProfileMenuCol()
        Spacer(modifier = Modifier.weight(1f))
        NavigationBar(
            modifier = Modifier,
            navController = navController
        )
    }
}

@Composable
fun ProfileBox() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(197.dp)
            .padding(top = 40.dp, bottom = 14.dp, start = 20.dp, end = 20.dp)
    ) {
        UserInfo()
        Spacer(modifier = Modifier.height(24.dp))
        RecordBox()
    }
}

@Composable
fun UserInfo() {
    val name = "나제준"
    val introduce = "성장하는 개발자, 나제준 입니다."
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(
                    color = colorResource(id = R.color.gray1),
                    shape = RoundedCornerShape(40.dp)
                )
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column (
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = bold,
                color = colorResource(id = R.color.gray5)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = introduce,
                fontSize = 14.sp,
                lineHeight = 19.6.sp,
                fontFamily = regular,
                color = colorResource(id = R.color.gray5)
            )
        }
    }
}

@Composable
fun RecordBox() {
    Row (
        modifier = Modifier
            .height(63.dp)
            .fillMaxWidth()
            .background(
                color = colorResource(id = R.color.gray1),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 12.dp),
    ) {
        RecordData(100, "작성 경험")
        RecordData(40, "완료 경험")
        RecordData(1200, "참여 경험")
    }
}

@Composable
fun RecordData(count: Int, text: String) {
    Column (
        modifier = Modifier
            .height(39.dp)
            .width(118.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            fontSize = 16.sp,
            lineHeight = 22.4.sp,
            fontFamily = semibold,
            color = colorResource(id = R.color.gray5)
        )
        Text(
            text = text,
            fontSize = 12.sp,
            lineHeight = 16.4.sp,
            fontFamily = regular,
            color = colorResource(id = R.color.gray4)
        )
    }
}
@Composable
fun ProfileMenuCol() {
    Column {
        ProfileMenu(imageId = R.drawable.account, text = "프로필 설정")
        ProfileMenu(imageId = R.drawable.sign, text = "작성한 글")
        ProfileMenu(imageId = R.drawable.participate, text = "참여한 글")
        ProfileMenu(imageId = R.drawable.security, text = "계정 관리")
    }
}


@Preview (showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileScreen()
}