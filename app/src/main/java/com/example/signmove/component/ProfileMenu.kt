package com.example.signmove.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.medium
import com.example.signmove.screen.ProfileScreen

@Composable
fun ProfileMenu(
    imageId: Int,
    text: String
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .padding(vertical = 14.dp, horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.width(14.dp))
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(14.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            lineHeight = 22.4.sp,
            fontFamily = medium,
            color = colorResource(id = R.color.gray5)
        )
    }
}





@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    ProfileScreen()
}