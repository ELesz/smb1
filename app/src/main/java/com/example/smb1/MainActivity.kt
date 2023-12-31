package com.example.smb1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smb1.ui.theme.SMB1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMB1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainMenu()
                }
            }
        }
    }
}

@Composable
fun MainMenu(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Spacer(modifier = Modifier.requiredHeight(15.dp))
        Button(onClick = {
            val intentListActivity = Intent(context, ListActivity::class.java)
            context.startActivity(intentListActivity)
            },
            modifier = Modifier
                .requiredWidth(300.dp)
                .requiredHeight(50.dp)
        ) {
            Text(text = "Moje listy")
        }
        Spacer(modifier = Modifier.requiredHeight(15.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Ustawienia konta")
        }
        Spacer(modifier = Modifier.requiredHeight(15.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
    SMB1Theme {
        MainMenu()
    }
}