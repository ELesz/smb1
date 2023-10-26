package com.example.smb1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smb1.ui.theme.SMB1Theme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMB1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListModification()
                }
            }
        }
    }
}

@Composable
fun ListModification(modifier: Modifier = Modifier){
    val context = LocalContext.current
    val listOfShoppingLists = remember { mutableStateOf(listOf<String>())}
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
            text = "This is list of lists page",
            modifier = modifier
        )
        LazyColumn(modifier = Modifier.requiredHeight(400.dp)){
            items(listOfShoppingLists.value){
                Row(){
                    Text(
                        text = it
                    )
                    Spacer(modifier = Modifier.requiredWidth(15.dp))
                    Button(
                        onClick = {
                            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                        }
                    ){
                        Text("show")
                    }
                }

                Divider()
            }
        }
    }
}


@Preview
@Composable
fun ListModificationPreview(){
    SMB1Theme {
        AccountScreen()
    }
}