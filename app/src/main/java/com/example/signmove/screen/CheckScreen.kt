package com.example.signmove.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.api.Client
import com.example.signmove.bold
import com.example.signmove.component.Button
import com.example.signmove.model.SetUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

@Composable
fun CheckScreen(name: String?, description: String?, town: String?, navController: NavHostController = rememberNavController()) {
    Column (
       modifier = Modifier
           .fillMaxSize()
           .background(color = colorResource(id = R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.check),
            contentDescription = "완료"
        )
        Spacer(modifier = Modifier.height(14.dp))
        Text(
            text = "회원가입이\n완료되었어요!",
            color = colorResource(id = R.color.gray5),
            textAlign = TextAlign.Center,
            fontFamily = bold,
            fontSize = 24.sp,
            lineHeight = 33.6.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(text = "완료") {
            val user = SetUser(
                email = "23sunrin083@sunrint.hs.kr",
                nickname = "김현호",
                description = "신용불량자",
                region = "서울시 강서구 화곡동",
                image = ""
            )
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    val res = Client.userService.setUser(user)
                    if (res.isSuccessful) {
                        navController.navigate("main")
                    }
                } catch (e: HttpException) {
                    Log.d("test", "HTTP Exception: ${e.message()}")
                } catch (e: Exception) {
                    Log.d("test", "Exception: ${e.message}")
                }
            }
        }
    }
}

