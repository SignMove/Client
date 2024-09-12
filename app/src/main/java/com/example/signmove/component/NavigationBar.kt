package com.example.signmove.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.signmove.R

@Composable
fun NavigationBar(modifier: Modifier = Modifier, navController: NavHostController) {
    val currentRoute = currentRoute(navController)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.white))
    ) {
        Layer()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(vertical = 8.dp)
                .background(color = colorResource(id = R.color.white)),
            horizontalArrangement = Arrangement.Center
        ) {
            NavigationItem(
                iconResId = if (currentRoute == "main") R.drawable.selectedhome else R.drawable.home,
                label = "홈",
                isSelected = currentRoute == "main",
                onClick = { navController.navigate("main") },
                modifier = Modifier.weight(1f)
            )
            NavigationItem(
                iconResId = if (currentRoute == "issue") R.drawable.selectedissue else R.drawable.issue,
                label = "이슈",
                isSelected = currentRoute == "issue",
                onClick = { navController.navigate("issue") },
                modifier = Modifier.weight(1f)
            )
            NavigationItem(
                iconResId = if (currentRoute == "sign") R.drawable.selectedsign else R.drawable.sign,
                label = "서명",
                isSelected = currentRoute == "sign",
                onClick = { navController.navigate("sign") },
                modifier = Modifier.weight(1f)
            )
            NavigationItem(
                iconResId = if (currentRoute == "profile") R.drawable.selectedprofile else R.drawable.profile,
                label = "프로필",
                isSelected = currentRoute == "profile",
                onClick = { navController.navigate("profile") },
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Composable
fun NavigationItem(iconResId: Int, label: String, isSelected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(42.dp)
            .clickable(onClick = onClick),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = label,
            tint = if (isSelected) colorResource(id = R.color.gray5) else colorResource(id = R.color.gray3)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 10.sp,
            lineHeight = 14.sp,
            color = if (isSelected) colorResource(id = R.color.gray5) else colorResource(id = R.color.gray3),
        )
    }
}


@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

//@Preview (showBackground = true)
//@Composable
//fun NavigationPreView() {
//    NavigationBar()
//}