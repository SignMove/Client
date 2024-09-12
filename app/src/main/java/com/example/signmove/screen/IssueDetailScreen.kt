package com.example.signmove.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.component.GoBackBar
import com.example.signmove.regular

@Composable
fun IssueDetailScreen(navController: NavHostController = rememberNavController()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp)
                .background(color = colorResource(id = R.color.white))
        ) {
            item { GoBackBar {
                navController.navigate("issue")
            } }
            val signInfo = SignInfo(
                town = "동아일보",
                writer = "작성자",
                min = 40,
                title = "대통령실 “2025년 의대 증원 재논의 불가능”"
            )
            item { SignTitle(signInfo = signInfo) }
            item { IssueImageInputBox() }
            item { IssueTextBox() }
            item {
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                        .fillMaxWidth()
                        .background(color = colorResource(id = R.color.gray1))
                )
            }
            item { CommentTitle() }
            item { CommentCol() }
        }
        CommentInsert(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun IssueImageInputBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(180.dp)
            .background(
                color = colorResource(id = R.color.gray1),
                shape = RoundedCornerShape(8.dp)
            )
    )
}

@Composable
fun IssueTextBox() {
    val contenttext = "대통령실은 9일 의료계가 여·야·의·정 협의체 구성 전제 조건으로 내세운 ‘2025년 의대 증원 재논의’ 요구에 대해 “현실적으로 불가능하다”는 입장을 거듭 밝혔다. 보건복지부 장·차관 등 책임자 경질 요구에 대해서도 수용할 수 없다는 입장을 유지했다.\n" +
            "\n" +
            "대통령실 관계자는 이날 용산 대통령실에서 기자들을 만나 의료계가 여·야·의·정 협의체 참여 조건으로 2025년 의대 증원 백지화를 요구하고 있는 데 대해 “2025년 의대 증원 유예는 현실적으로 불가능하다라는 점을 (이미) 분명히 했다”고 말했다. 이어 “이미 오늘부터 2025년 수시가 시작돼 교육부에서도 대혼란을 야기할 수 있어 불가하다는 입장을 낸 바 있다”고 덧붙였다."
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp, horizontal = 20.dp)
    ) {
        Text(
            text = contenttext,
            color = colorResource(id = R.color.gray5),
            fontFamily = regular,
            fontSize = 14.sp,
            lineHeight = 19.6.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun IssueInDetailPreview() {
    IssueDetailScreen()
}