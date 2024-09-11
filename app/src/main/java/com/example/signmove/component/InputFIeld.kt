package com.example.signmove.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.medium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(descriptext: String? = null, inputtext: String) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        descriptext?.let {
            Text(
                text = it,
                color = colorResource(id = R.color.gray5),
                fontFamily = medium,
                fontSize = 16.sp,
                lineHeight = 22.4.sp,
                modifier = Modifier.padding(start = 6.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        androidx.compose.material3.TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            placeholder = {
                Text(
                    text = inputtext,
                    color = colorResource(id = R.color.gray3),
                    fontFamily = medium,
                    fontSize = 16.sp,
                    lineHeight = 22.4.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.gray2),
                    shape = RoundedCornerShape(8.dp)
                )
                .background(
                    color = colorResource(id = R.color.gray1),
                    shape = RoundedCornerShape(8.dp)
                ),
            textStyle = androidx.compose.ui.text.TextStyle(
                color = colorResource(id = R.color.gray3),
                fontFamily = medium,
                fontSize = 14.sp,
                lineHeight = 19.6.sp
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview (showBackground = true)
@Composable
fun FieldPreview() {
    InputField(descriptext = "앙김호지", inputtext = "깁호지")
}