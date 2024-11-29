package com.neonstudio.jetpackcomposepractice._1Basics


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.R
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class Basics : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    TextFunction(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    TextFieldFunction(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextFunction(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ImageFunction(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Dummy Image",
        colorFilter = ColorFilter.tint(Color.Blue),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ButtonFunction(modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White
        ),
        enabled = false
    ) {
        Text("Hello")
        Image(
            painter = painterResource(id= R.drawable.ic_launcher_background),
            contentDescription = "Dummy")
    }
}

@Composable
fun TextFieldFunction(modifier: Modifier = Modifier) {
    TextField(
        value = "Txt Value",
        onValueChange = {
            Log.d("Testing9292",it)
        },
        label = { Text(text = "Enter Message") },
        //placeholder = {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {
        // TextFunction("Android")
        // ImageFunction()
        // ButtonFunction()
        TextFieldFunction()
    }
}