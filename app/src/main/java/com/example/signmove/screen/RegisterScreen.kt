package com.example.signmove.screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.signmove.R
import com.example.signmove.bold

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class RegisterActivity : ComponentActivity() {

    private lateinit var signInLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Google 로그인 결과 처리
        signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        }

        setContent {
            GoogleSignInScreen { googleRequest(this, signInLauncher) }
        }
    }
}

@Composable
fun GoogleSignInScreen(onGoogleSignInClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {
        Text(
            text = "서명으로 시작하는\n작은 발걸음",
            color = colorResource(id = R.color.gray5),
            textAlign = TextAlign.Center,
            fontFamily = bold,
            fontSize = 28.sp,
            lineHeight = 39.2.sp,
            modifier = Modifier.align(Alignment.Center)
        )
        com.example.signmove.component.Button(
            text = "시작하기",
            modifier = Modifier
                .align(Alignment.BottomCenter),
            onClick = onGoogleSignInClick
        )
    }
}

fun googleRequest(
    context: Activity,
    signInLauncher: ActivityResultLauncher<Intent>
) {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()
    val googleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(context, gso)

    val signInIntent = googleSignInClient.signInIntent
    signInLauncher.launch(signInIntent)
}

fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
    try {
        val account = completedTask.getResult(ApiException::class.java)
        val email = account.email
        val displayName = account.displayName

        Log.d("test", email.toString())
        Log.d("test", displayName.toString())
    } catch (e: ApiException) {
        e.printStackTrace()
    }
}


@Preview (showBackground = true)
@Composable
fun RegisterPreview() {
    GoogleSignInScreen {

    }
}