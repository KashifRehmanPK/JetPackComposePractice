package com.neonstudio.jetpackcomposepractice._12Theme


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class Theme2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    App(

                    )
                }
            }
        }
    }
}

@Composable
fun App() {
    var theme = remember { mutableStateOf(false) }
    JetPackComposePracticeTheme(theme.value) {

        Column(Modifier.background(MaterialTheme.colorScheme.background )) {

            Text(
                text = "CheezyCode",
                style = MaterialTheme.typography.headlineLarge
            )
            Button(onClick = {
                theme.value = !theme.value
            }) {

                Text(text = "Change Theme")

            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        App()
    }
}