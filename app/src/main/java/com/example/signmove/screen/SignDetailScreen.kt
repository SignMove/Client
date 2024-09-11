package com.example.signmove.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.signmove.R
import com.example.signmove.SignInfo
import com.example.signmove.bold
import com.example.signmove.component.Button
import com.example.signmove.component.CommentBox
import com.example.signmove.component.CommentInputField
import com.example.signmove.component.GoBackBar
import com.example.signmove.medium
import com.example.signmove.regular

@Composable
fun SignDetailScreen(navController: NavHostController = rememberNavController()) {
    var isSignatureDialogOpen by remember { mutableStateOf(false) }

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
            item { GoBackBar() }
            item { SignImageInputBox() }
            val signInfo = SignInfo(
                town = "서울",
                writer = "작성자",
                min = 5,
                title = "제목"
            )
            item { SignTitle(signInfo = signInfo) }
            item { SignCountBox() }
            item { Button(text = "서명하기") { isSignatureDialogOpen = true } }
            item { SignTextBox() }
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

        if (isSignatureDialogOpen) {
            SignatureDialog(onDismiss = { isSignatureDialogOpen = false })
        }
    }
}

@Composable
fun SignImageInputBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .background(color = colorResource(id = R.color.gray1))
    )
}

@Composable
fun SignTitle(signInfo: SignInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 14.dp, horizontal = 20.dp)
    ) {
        Text(
            text = signInfo.title,
            color = colorResource(id = R.color.gray5),
            fontFamily = bold,
            fontSize = 18.sp,
            lineHeight = 25.2.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = signInfo.town,
                fontSize = 14.sp,
                fontFamily = regular,
                lineHeight = 19.6.sp,
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
                text = "${signInfo.min}분 전",
                fontSize = 14.sp,
                fontFamily = regular,
                lineHeight = 19.6.sp,
                color = colorResource(id = R.color.primary)
            )
        }
    }
}

@Composable
fun SignCountBox() {
    val signcount = 12000
    val formattedSignCount = String.format("%,d", signcount)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 2.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = "${formattedSignCount}명",
            color = colorResource(id = R.color.primary),
            fontFamily = medium,
            fontSize = 14.sp,
            lineHeight = 19.6.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
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
fun SignTextBox() {
    val contenttext = "쓰레기를 버리고 싶어도 주변에 쓰레기통이 없어서 불편하지 않으신가요? 최소한 공원에는 필수적으로 쓰레기통을 배치해주었으면 합니다. 따라서 이에 대한 건의를 올려보려는데, 여러분의 서명이 필요합니다. 부디 도움을 주십시오."
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 14.dp, start = 20.dp, end = 20.dp)
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

@Composable
fun CommentTitle() {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 8.dp, end = 20.dp)
            .background(color = colorResource(id = R.color.white))
    ) {
        Text(
            text = "댓글",
            color = colorResource(id = R.color.gray5),
            fontFamily = bold,
            fontSize = 18.sp,
            lineHeight = 25.2.sp
        )
    }
}

@Composable
fun CommentCol() {
    Column {
        CommentBox()
        CommentBox()
        CommentBox()
        CommentBox()
        CommentBox()
        CommentBox()
        CommentBox()
    }
}

@Composable
fun CommentInsert(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.white))
    ) {
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.gray1))
        )
        Row(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 20.dp)
                .fillMaxWidth()
        ) {
            CommentInputField(inputtext = "댓글을 입력해주세요")
            Spacer(modifier = Modifier.width(12.dp))
            Box(
                modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.primary),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .size(56.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_upward),
                    contentDescription = "등록"
                )
            }
        }
    }
}

@Composable
fun SignatureDialog(onDismiss: () -> Unit) {
    val brushColor = colorResource(id = R.color.gray5)
    var path by remember { mutableStateOf(Path()) }
    var drawing by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.black).copy(alpha = 0.28f))
            .wrapContentSize(Alignment.Center)
    ) {
        Column(
            modifier = Modifier
                .width(353.dp)
                .padding(vertical = 20.dp)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(12.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "이곳에 서명해주세요",
                color = brushColor,
                textAlign = TextAlign.Center,
                fontFamily = bold,
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))
            Canvas(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .background(
                        color = colorResource(id = R.color.gray1),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.gray2),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = { offset ->
                                drawing = true
                                path.moveTo(offset.x, offset.y)
                            },
                            onDragEnd = {
                                drawing = false
                            },
                            onDrag = { change, _ ->
                                if (drawing) {
                                    path.lineTo(change.position.x, change.position.y)
                                }
                            }
                        )
                        detectTapGestures {
                            path.reset()
                        }
                    }
            ) {
                drawPath(
                    path = path,
                    color = brushColor,
                    style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Button(text = "완료") {
                onDismiss()
            }
        }
    }
}







@Preview (showBackground = true)
@Composable
fun SignInDetailPreview() {
    SignatureDialog {

    }
}
