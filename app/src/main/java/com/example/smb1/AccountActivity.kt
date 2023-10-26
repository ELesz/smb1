package com.example.smb1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smb1.ui.theme.SMB1Theme

class AccountActivity :ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMB1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AccountScreen()
                }
            }
        }
    }
}

@Composable
fun AccountScreen(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Column {
        Button(onClick = {
            val intentBackToMainActivity = Intent(context, MainActivity::class.java)
            context.startActivity(intentBackToMainActivity)
        }) {
            Text(
                text = "Back to home screen",
                modifier = modifier
            )
        }
        Spacer(modifier = Modifier.requiredHeight(15.dp))
        Text(
            text = "This is account page",
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun AccountScreenPreview(){
    SMB1Theme {
        AccountScreen()
    }
}