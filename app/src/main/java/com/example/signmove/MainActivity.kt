package com.example.signmove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.signmove.screen.CheckScreen
import com.example.signmove.screen.HomeScreen
import com.example.signmove.screen.InputIntroScreen
import com.example.signmove.screen.InputNameScreen
import com.example.signmove.screen.IssueDetailScreen
import com.example.signmove.screen.IssueScreen
import com.example.signmove.screen.ProfileScreen
import com.example.signmove.screen.RegionSelectScreen
import com.example.signmove.screen.SearchScreen
import com.example.signmove.screen.SelectTownScreen
import com.example.signmove.screen.SignDetailScreen
import com.example.signmove.screen.SignScreen
import com.example.signmove.screen.SignWriteScreen
import com.example.signmove.ui.theme.SignMoveTheme


val bold = FontFamily(
    Font(R.font.bold)
)
val medium = FontFamily(
    Font(R.font.medium)
)
val semibold = FontFamily(
    Font(R.font.semibold)
)
val regular = FontFamily(
    Font(R.font.regular)
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignMoveTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "sign detail") {
                    composable("name") { InputNameScreen(navController)}
                    composable("intro") { InputIntroScreen(navController)}
                    composable("town") { SelectTownScreen(navController)}
                    composable("check") { CheckScreen(navController)}
                    composable("main") { HomeScreen(navController)}
                    composable("issue") { IssueScreen(navController)}
                    composable("issue detail") { IssueDetailScreen(navController)}
                    composable("sign") { SignScreen(navController)}
                    composable("sign detail") { SignDetailScreen(navController)}
                    composable("sign write") { SignWriteScreen(navController)}
                    composable("region select") { RegionSelectScreen(navController) }
                    composable("search") { SearchScreen(navController) }
                    composable("profile") { ProfileScreen(navController)}
                }
            }
        }
    }
}

